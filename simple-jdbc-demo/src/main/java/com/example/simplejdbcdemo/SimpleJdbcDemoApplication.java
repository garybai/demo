package com.example.simplejdbcdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

/**
 * @description: TODO
 * @author Gary
 *
 * @date 2019-04-06 09:27
 */

@Slf4j
@SpringBootApplication
public class SimpleJdbcDemoApplication implements CommandLineRunner {

    @Autowired
    private FooDao fooDao;

    @Autowired
    private BatchFooDao batchFooDao;

    public static void main(String[] args) {
        SpringApplication.run(SimpleJdbcDemoApplication.class, args);
    }

    @Bean
    @Autowired
    public SimpleJdbcInsert simpleJdbcInsert(JdbcTemplate jdbcTemplate) {
        return new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("FOO").usingGeneratedKeyColumns("ID");
    }

    @Override
    public void run(String... args) throws Exception {
//        fooDao.inserData();
        batchFooDao.batchInsert();
        fooDao.listData();
    }
}
