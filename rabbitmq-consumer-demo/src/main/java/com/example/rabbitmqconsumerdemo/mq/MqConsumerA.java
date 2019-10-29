package com.example.rabbitmqconsumerdemo.mq;

import com.example.rabbitmqconsumerdemo.config.MqConfig;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Gary
 * @className MqConsumer
 * @description TODO
 * @date 2019-06-29 12:34
 **/
@Component
@Slf4j
@RabbitListener(queues = {MqConfig.QUEUE_A, MqConfig.QUEUE_B})
public class MqConsumerA implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback, InitializingBean {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitHandler
    public void process(String content, Channel channel, Message message) throws Exception {

        String correlationId = message.getMessageProperties().getHeaders().get("spring_returned_message_correlation").toString();
        try {
            //这里是业务逻辑
            Thread.sleep(1000);
            if ("I'm message 3".equalsIgnoreCase(content)) {
                System.out.println(10 / 0);
            }

            System.out.println("consumerA消费成功: " + content + ", id是: " + correlationId);
            //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            System.err.println("consumerA消费失败: " + content + ", id是: " + correlationId);

            Object retryCountO = message.getMessageProperties().getHeaders().get("retryCount");

                if (null == retryCountO) {
                retryCountO = 1;
            }
            Integer retryCount = (Integer) retryCountO;

            System.out.println("重试第" + retryCount + "次...");
            CorrelationData correlationData = new CorrelationData(correlationId);
            // 重试次数小于3，重新发送到mq
            if (retryCount < 3) {
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
                this.rabbitTemplate.convertAndSend(MqConfig.EXCHANGE_A, MqConfig.ROUTINGKEY_A, content, (Message msg) -> {
                    msg.getMessageProperties().getHeaders().put("retryCount", retryCount + 1);
                    return msg;
                }, correlationData);

            } else {
                System.out.println("保存异常消息到数据库, id是: " + correlationId);
                // 告诉mq服务器此消息已消费
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            }

        }

    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            System.out.println("confirm: id是" + correlationData.getId() + "的消息已投递成功。");
        } else {
            System.out.println("confirm: id是" + correlationData.getId() + "的消息投递失败，原因：" + cause);
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

}
