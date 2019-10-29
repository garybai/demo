package com.example.multidatasourcedemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;

/**
 * @author Gary
 * @description: TODO
 * @date 2019-04-05 22:39
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        JdbcTemplateAutoConfiguration.class})
@Slf4j
public class MultiDataSourceDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiDataSourceDemoApplication.class, args);
    }

}
