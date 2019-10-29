package com.example.mybatisdemo;

import com.example.mybatisdemo.mapper.CoffeeMapper;
import com.example.mybatisdemo.model.Coffee;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@MapperScan("com.example.mybatisdemo.mappers")
@Slf4j
public class MybatisDemoApplication implements CommandLineRunner {

    @Autowired
    private CoffeeMapper coffeeMapper;

    public static void main(String[] args) {
        SpringApplication.run(MybatisDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*Coffee coffee = new Coffee().setName("espresso")
                .setPrice(Money.of(CurrencyUnit.of("CNY"), 20.0));
        Long id = coffeeMapper.save(coffee);
        log.info("Coffee {} => {}", id, coffee);

        Coffee coffee1 = coffeeMapper.findById(id);
        log.info("Coffee {}", coffee1);*/
        coffeeMapper.findAllWithRowBounds(new RowBounds(1, 3))
                .forEach(coffee -> log.info("Page 1 Coffee {}", coffee));
        coffeeMapper.findAllWithRowBounds(new RowBounds(2, 3))
                .forEach(coffee -> log.info("Page 2 Coffee {}", coffee));

        log.info("====================");

        coffeeMapper.findAllWithRowBounds(new RowBounds(1, 0))
                .forEach(coffee -> log.info("Page 1 Coffee {}", coffee));

        log.info("====================");

        coffeeMapper.findAllWithParam(1, 3)
                .forEach(coffee -> log.info("Page 1 Coffee{}", coffee));
        List<Coffee> list = coffeeMapper.findAllWithParam(2, 3);
        PageInfo page = new PageInfo(list);
        log.info("PageInfo: {}", page);
    }
}
