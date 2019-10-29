package com.example.druiddemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

/**
 * @description: TODO
 * @author Gary
 *
 * @date 2019-04-06 00:41
 */
@SpringBootApplication
@Slf4j
public class DruidDemoApplication implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(DruidDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info(dataSource.toString());
    }
}
