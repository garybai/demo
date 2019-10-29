package com.example.rabbitmqproducerdemo.mq;

import com.example.rabbitmqproducerdemo.config.MqConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author Gary
 * @className MqSender
 * @description TODO
 * @date 2019-06-29 12:28
 **/
@Component
@Slf4j
public class MqSender implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback, InitializingBean {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String content) {

        System.out.println("send: " + content);
        CorrelationData correlationData = this.correlationData(content);
        correlationData.setExchange(MqConfig.EXCHANGE_A)
                .setRoutingKey(MqConfig.ROUTINGKEY_A)
                .setRetryCount(0)
                .setMessage(content);
        System.out.println("send: id是" + correlationData.getId() + "的消息开始投递。");

        // exchange正确 queue正确，confirm被回调，ack=true
        this.rabbitTemplate.convertAndSend(MqConfig.EXCHANGE_A, MqConfig.ROUTINGKEY_A, content, (Message message) -> {
            message.getMessageProperties().getHeaders().put("retryCount", 0);
            return message;
        }, correlationData);

        //exchange错误 queue正确，confirm被回调，ack=false
//        this.rabbitTemplate.convertAndSend("a", MqConfig.ROUTINGKEY_A, content, (Message message) -> {
//            message.getMessageProperties().getHeaders().put("retryCount", 0);
//            return message;
//        }, correlationData);

        // exchange正确 queue错误，confirm被回调，ack=true，return被回调，replyText=NO_ROUTE
        //this.rabbitTemplate.convertAndSend(MqConfig.EXCHANGE_A, "b", content, correlationData);

        // exchange错误 queue错误，confirm被回调，ack=false
        // this.rabbitTemplate.convertAndSend("a", "b", content, correlationData);

        // 可以同时投递多个队列
        //this.rabbitTemplate.convertAndSend(MqConfig.EXCHANGE_B, MqConfig.ROUTINGKEY_B, content, correlationData);
    }

    @Override
    public void confirm(org.springframework.amqp.rabbit.connection.CorrelationData correlationData, boolean ack, String cause) {
        if (!ack && correlationData instanceof CorrelationData) {
            System.out.println("confirm: id是" + correlationData.getId() + "的消息投递失败，原因：" + cause);
            CorrelationData correlationDataExtends = (CorrelationData) correlationData;
            System.out.println(correlationDataExtends);

            //消息发送失败,就进行重试，重试过后还不能成功就记录到数据库
            if (correlationDataExtends.getRetryCount() < 3) {

                // 将重试次数加一
                correlationDataExtends.setRetryCount(correlationDataExtends.getRetryCount() + 1);

                System.err.println("id是: " + correlationDataExtends.getId() + ", 重发第" + correlationDataExtends.getRetryCount() + "次");
                // 重发发消息
                this.rabbitTemplate.convertAndSend("b",
                        correlationDataExtends.getRoutingKey(), correlationDataExtends.getMessage(), (Message message) -> {
                            message.getMessageProperties().getHeaders().put("retryCount", 0);
                            return message;
                        }, correlationDataExtends);
            } else {
                //消息重试发送失败,将消息放到数据库等待补发
                System.err.println("消息重发失败, id是: " + correlationDataExtends.getId());

                // TODO 保存消息到数据库
            }
        } else {
            System.out.println("confirm: id是" + correlationData.getId() + "的消息投递成功");
        }
    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        System.out.println("return--message:" + new String(message.getBody()) + ",replyCode:"
                + replyCode + ",replyText:" + replyText + ",exchange:" + exchange + ",routingKey:" + routingKey);
    }

    @Override
    public void afterPropertiesSet() {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnCallback(this);
    }

    /**
     * 消息相关数据（消息ID）
     *
     * @param message
     * @return
     */
    private CorrelationData correlationData(Object message) {

        return new CorrelationData(UUID.randomUUID().toString(), message);
    }

}
