package com.example.unnameddemo.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Gary
 * @className MyCommandRunner
 * @description TODO
 * @date 2019-10-26 20:45
 **/
@Component
@Order(value = 10)
public class MyCommandLineRunner1 implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("This is MyCommandLineRunner1, order 10, " + Arrays.toString(args));

    }

}
