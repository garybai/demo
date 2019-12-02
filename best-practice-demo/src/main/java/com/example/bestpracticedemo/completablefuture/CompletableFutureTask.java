package com.example.bestpracticedemo.completablefuture;

import com.example.bestpracticedemo.threadpool.MyThreadFactory;

import java.time.LocalTime;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * CompletableFuture 实现烧水泡茶
 *
 * @author Gary
 * @date 2019/11/27 14:08
 * @since jdk1.8
 **/
public class CompletableFutureTask {

    private static ThreadPoolExecutor executor =
            new ThreadPoolExecutor(3, 3, 5, TimeUnit.SECONDS,
                    new ArrayBlockingQueue<>(10), new MyThreadFactory(), new ThreadPoolExecutor.AbortPolicy()
            );

    private static void doTea() {
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + "洗茶壶……" + LocalTime.now());
            sleep(1, TimeUnit.SECONDS);

            System.out.println(threadName + "洗茶杯……" + LocalTime.now());
            sleep(3000, TimeUnit.MILLISECONDS);

            System.out.println(threadName + "拿茶叶……" + LocalTime.now());
            sleep(1, TimeUnit.SECONDS);
            return "龙井";
        }, executor);

        CompletableFuture<Void> cf2 = CompletableFuture.runAsync(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + "洗水壶……" + LocalTime.now());
            sleep(2, TimeUnit.SECONDS);

            System.out.println(threadName + "烧开水……" + LocalTime.now());
            sleep(2, TimeUnit.SECONDS);
        }, executor);

        CompletableFuture<String> cf3 = cf1.thenCombine(cf2, (tf, x) -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("拿到茶叶" + tf + LocalTime.now());
            return threadName + "上茶" + tf + LocalTime.now();
        }).exceptionally(throwable -> "aa");

        System.out.println(cf3.join());

    }

    private static void sleep(int t, TimeUnit unit) {
        try {
            unit.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        doTea();
    }

}
