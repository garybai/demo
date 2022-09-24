package com.example.dubboproviderdemo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class DubboProviderDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DubboProviderDemoApplication.class, args);
	}

}
