package com.example.rabbitmqconsumerdemo;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class RabbitmqConsumerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqConsumerDemoApplication.class, args);
    }

}
