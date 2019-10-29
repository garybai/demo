package com.example.springbootstarterdemo;

import com.example.springbootstarterdemo.config.HelloProperties;
import com.example.springbootstarterdemo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Gary
 * @className HelloServiceAutoConfiguration
 * @description TODO
 * @date 2019-10-22 16:45
 **/
@Configuration
@EnableConfigurationProperties(value = HelloProperties.class)
@ConditionalOnClass(value = HelloService.class)
public class HelloServiceAutoConfiguration {

    @Autowired
    HelloProperties helloProperties;

    @Bean
    HelloService helloService() {
        HelloService helloService = new HelloService();
        helloService.setName(helloProperties.getName());
        helloService.setMsg(helloProperties.getMsg());
        return helloService;
    }
}
