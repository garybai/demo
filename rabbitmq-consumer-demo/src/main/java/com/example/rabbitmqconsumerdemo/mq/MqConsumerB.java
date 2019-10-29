package com.example.rabbitmqconsumerdemo.mq;

import com.example.rabbitmqconsumerdemo.config.MqConfig;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Gary
 * @className MqConsumer
 * @description TODO
 * @date 2019-06-29 12:34
 **/
@Component
@Slf4j
@RabbitListener(queues = MqConfig.QUEUE_B)
public class MqConsumerB {

    @RabbitHandler
    public void process(String content, Channel channel, Message message) {

        try {
            Thread.sleep(1000);
            log.info("consumerB success {}", content);
            //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e){
            e.printStackTrace();
            log.error("consumerB failed");
        }

    }
}
