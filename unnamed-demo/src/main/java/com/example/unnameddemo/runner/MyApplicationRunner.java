package com.example.unnameddemo.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author Gary
 * @className MyApplicationRunner
 * @description TODO
 * @date 2019-10-26 20:49
 **/
@Component
@Order(value = 8)
public class MyApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("This is MyApplicationRunner, order 8");
        List<String> nonOptionArgs = args.getNonOptionArgs();
        System.out.println("MyApplicationRunner" + nonOptionArgs);

        Set<String> optionNames = args.getOptionNames();
        optionNames.stream().parallel().forEach(s -> {
            System.out.println("key: " + s + "  value: " + args.getOptionValues(s));
        });

        String[] sourceArgs = args.getSourceArgs();
        System.out.println(Arrays.toString(sourceArgs));

    }
}
