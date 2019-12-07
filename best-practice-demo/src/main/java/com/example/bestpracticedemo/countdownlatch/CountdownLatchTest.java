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

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        System.out.println("主线程开始。" + LocalTime.now());
        ExecutorService es1 = Executors.newSingleThreadExecutor();
        es1.execute(()->{
            System.out.println("子线程 1 开始执行。" + LocalTime.now());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程 1 执行完毕。" + LocalTime.now());
            countDownLatch.countDown();
        });
        es1.shutdown();
        ExecutorService es2 = Executors.newSingleThreadExecutor();
        es2.execute(()->{
            System.out.println("子线程 2 开始执行。" + LocalTime.now());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程 2 执行完毕。" + LocalTime.now());
            countDownLatch.countDown();
        });
        es2.shutdown();
        System.out.println("等等两个线程执行完毕。" + LocalTime.now());
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("两个子线程都执行完毕。" + LocalTime.now());
    }
}
