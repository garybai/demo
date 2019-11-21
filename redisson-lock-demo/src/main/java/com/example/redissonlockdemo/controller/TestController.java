package com.example.redissonlockdemo.controller;

import cn.hutool.core.thread.ThreadFactoryBuilder;
import com.example.redissonlockdemo.config.DistributedLocker;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * @author Gary
 * @className TestController
 * @description TODO
 * @date 2019/11/20 11:12
 **/
@RestController
@Slf4j
public class TestController {

    @Autowired
    private DistributedLocker distributedLocker;


    private ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10, 10, 10,
            TimeUnit.SECONDS, new LinkedBlockingDeque<>(), new ThreadFactoryBuilder().build(), new ThreadPoolExecutor.AbortPolicy());

    @GetMapping(value = "/test")
    public String test() throws InterruptedException {

        ArrayList<String> arrayList = new ArrayList<>(10);

        int clientcount = 10;
        String key = "lock1";
        CountDownLatch countDownLatch = new CountDownLatch(clientcount);

        ExecutorService executorService = Executors.newFixedThreadPool(clientcount);
        long start = System.currentTimeMillis();
        for (int i = 0; i < clientcount; i++) {
            executorService.execute(() -> {
                RLock lock = distributedLocker.getLock(key);

                try {
                    boolean b = lock.tryLock(60, 30, TimeUnit.SECONDS);
                    if (b) {
                        try {
                            System.out.println(Thread.currentThread().getName() + "获取到锁 " + LocalTime.now());
                            // 获取到锁之后休眠 3s，模拟业务逻辑
                            Thread.sleep(3000);
                            arrayList.add(Thread.currentThread().getName());
                        } finally {
                            System.out.println(Thread.currentThread().getName() + "解锁 " + LocalTime.now());
                            lock.unlock();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + "未获取到锁 " + LocalTime.now());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
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

    @GetMapping("/test1")
    public String test1() throws ExecutionException, InterruptedException {
        ArrayList<String> arrayList = new ArrayList<>(10);

        int clientcount = 10;
        String key = "lock1";
        for (int i = 0; i < clientcount; i++) {
            Future<?> submit = poolExecutor.submit(() -> {
                RLock lock = distributedLocker.getLock(key);
                try {
                    boolean b = lock.tryLock(60, 30, TimeUnit.SECONDS);
                    if (b) {
                        try {
                            System.out.println(Thread.currentThread().getName() + "获取到锁 " + LocalTime.now());
                            // 获取到锁之后休眠 3s，模拟业务逻辑
                            Thread.sleep(3000);
                            arrayList.add(Thread.currentThread().getName());
                        } finally {
                            System.out.println(Thread.currentThread().getName() + "解锁 " + LocalTime.now());
                            lock.unlock();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + "未获取到锁 " + LocalTime.now());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
//            Object o = submit.get();
        }
        arrayList.forEach(System.out::println);
        return "hello";
    }

    public void hello() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://localhost:6379");
        RedissonClient redissonClient = Redisson.create(config);
        RLock lock = redissonClient.getLock("lockKey");
        try {
            lock.lock();
            // ...
        } finally {
            lock.unlock();
        }
    }

}
