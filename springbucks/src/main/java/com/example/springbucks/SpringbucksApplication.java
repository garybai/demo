package com.example.springbucks;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * TODO
 *
 * @author Gary
 * @date 2019-04-14 18:37
 */

@SpringBootApplication
@MapperScan("com.example.springbucks.dao")
@EnableTransactionManagement(mode = AdviceMode.PROXY)
@EnableCaching
public class SpringbucksApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbucksApplication.class, args);
    }

//    @Bean
//    public MongoCustomConversions mongoCustomConversions() {
//        return new MongoCustomConversions(Arrays.asList(new MoneyReadConverter()));
//    }

}
