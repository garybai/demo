package com.example.springsecuritydynamicdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.springsecuritydynamicdemo.mapper")
public class SpringsecurityDynamicDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringsecurityDynamicDemoApplication.class, args);
    }

}
