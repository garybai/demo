package com.example.bestpracticedemo.countdownlatch;

import java.time.LocalTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CountdownLatch测试
 *
 * @author Gary
 * @date 2019/12/6 18:05
 * @since jdk1.8
 **/
public class CountdownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程开始。" + LocalTime.now());
        ExecutorService es = Executors.newFixedThreadPool(2);
        CountDownLatch countDownLatch = new CountDownLatch(2);
        es.execute(() -> {
            getPOrders();
            countDownLatch.countDown();
        });
        es.execute(() -> {
            getDOrders();
            countDownLatch.countDown();
        });
        System.out.println("等等两个线程执行完毕。" + LocalTime.now());

        countDownLatch.await();

        System.out.println("两个子线程都执行完毕。" + LocalTime.now());
        check();
        save();
        es.shutdown();
    }

    private static void sleep(Integer timeout) {
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void getPOrders() {
        System.out.println(Thread.currentThread().getName() + "开始执行getPOrders " + LocalTime.now());
        sleep(3);
        System.out.println(Thread.currentThread().getName() + "执行getPOrders完毕 " + LocalTime.now());
    }

    private static void getDOrders() {
        System.out.println(Thread.currentThread().getName() + "开始执行getDOrders " + LocalTime.now());
        sleep(5);
        System.out.println(Thread.currentThread().getName() + "执行getDOrders完毕 " + LocalTime.now());
    }

    private static void check() {
        System.out.println(Thread.currentThread().getName() + "开始执行check " + LocalTime.now());
        sleep(1);
        System.out.println(Thread.currentThread().getName() + "执行check完毕 " + LocalTime.now());
    }

    private static void save() {
        System.out.println(Thread.currentThread().getName() + "开始执行save " + LocalTime.now());
        sleep(1);
        System.out.println(Thread.currentThread().getName() + "执行save完毕 " + LocalTime.now());
    }
}
