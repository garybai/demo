package com.example.dynamicdatasourcedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        JdbcTemplateAutoConfiguration.class})
//@ComponentScan(basePackages = "com.example.dynamicdatasourcedemo.mapper")
public class DynamicDatasourceDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicDatasourceDemoApplication.class, args);
    }

}
