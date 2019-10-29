package com.example.rabbitmqproducerdemo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Gary
 * @className MqConfig
 * @description TODO
 * @date 2019-06-29 12:08
 **/
@Configuration
@Slf4j
public class MqConfig {

    public static final String EXCHANGE_A = "exchange_A";
    public static final String EXCHANGE_B = "exchange_B";


    public static final String QUEUE_A = "QUEUE_A";
    public static final String QUEUE_B = "QUEUE_B";

    public static final String ROUTINGKEY_A = "routingKey_A";
    public static final String ROUTINGKEY_B = "routingKey_B";


    /**
     * 针对消费者配置
     * 1. 设置交换机类型
     * 2. 将队列绑定到交换机
     * FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念
     * HeadersExchange ：通过添加属性key-value匹配
     * DirectExchange:按照routingkey分发到指定队列
     * TopicExchange:多关键字匹配
     */
    @Bean
    public DirectExchange exchangeA() {
        return new DirectExchange(EXCHANGE_A);
    }

    @Bean
    public DirectExchange exchangeB() {
        return new DirectExchange(EXCHANGE_B);
    }

    /**
     * 获取队列A
     *
     * @return
     */
    @Bean
    public Queue queueA() {
        return new Queue(QUEUE_A, true);
    }

    @Bean
    public Queue queueB() {
        return new Queue(QUEUE_B, true);
    }

    @Bean
    public Binding bindingA() {
        return BindingBuilder.bind(queueA()).to(exchangeA()).with(MqConfig.ROUTINGKEY_A);
    }

    @Bean
    public Binding bindingB() {
        return BindingBuilder.bind(queueB()).to(exchangeB()).with(MqConfig.ROUTINGKEY_B);
    }

}
