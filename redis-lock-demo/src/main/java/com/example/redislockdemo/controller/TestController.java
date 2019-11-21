package com.example.redislockdemo.controller;

import com.example.redislockdemo.util.RedisLockUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Gary
 * @className TestController
 * @description TODO
 * @date 2019-11-14 17:46
 **/
@RestController
@Slf4j
public class TestController {


    @Autowired
    RedisLockUtil redisLockUtil;

    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping("/index")
    public String index() throws InterruptedException {

        ArrayList<String> arrayList = new ArrayList<>(10);

        int clientcount = 10;
        String key = "lock1";
        CountDownLatch countDownLatch = new CountDownLatch(clientcount);

        ExecutorService executorService = Executors.newFixedThreadPool(clientcount);
        long start = System.currentTimeMillis();
        for (int i = 0; i < clientcount; i++) {
            executorService.execute(() -> {
                String value = UUID.randomUUID().toString();
                try {

                    if (redisLockUtil.lock(key, value)){
                        try {
                            // 获取到锁之后休眠 3s，模拟业务逻辑
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        arrayList.add(Thread.currentThread().getName());
                    }
                } finally {
                    redisLockUtil.unlock(key, value);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        log.info("执行线程数:{},总耗时:{}", clientcount, end - start);
        arrayList.forEach(System.out::println);
        return "Hello";
    }
}
