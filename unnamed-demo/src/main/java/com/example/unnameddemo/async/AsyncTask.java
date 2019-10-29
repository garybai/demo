package com.example.unnameddemo.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @author Gary
 * @className AsyncTask
 * @description TODO
 * @date 2019-07-29 23:07
 **/
@Component
@Slf4j
public class AsyncTask {

    @Async
    public Future<String> task1() throws InterruptedException {
        long a = System.currentTimeMillis();
        Thread.sleep(1000);
        long b = System.currentTimeMillis();
        log.info("task1耗时" + (b - a) + "ms " + Thread.currentThread().getName());
        return new AsyncResult<>("task1 done");
    }

    @Async
    public Future<String> task2() throws InterruptedException {
        long a = System.currentTimeMillis();
        Thread.sleep(2000);
        long b = System.currentTimeMillis();
        log.info("task2耗时" + (b - a) + "ms " + Thread.currentThread().getName());
        return new AsyncResult<>("task2 done");
    }

    @Async
    public Future<Integer> task3() throws InterruptedException {
        long a = System.currentTimeMillis();
        Thread.sleep(3000);
        long b = System.currentTimeMillis();
        System.out.println("task3耗时" + (b - a) + "ms " + Thread.currentThread().getName());
        Long c = b - a;
        return new AsyncResult<>(Integer.valueOf(c.toString()));

    }
}
