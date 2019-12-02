package com.example.unnameddemo.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * CompletableFutureTask
 *
 * @author Gary
 * @date 2019/11/27 15:21
 * @since jdk1.8
 **/
public class CompletableFutureTask {

    public static void main(String[] args) {

        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            int t = getRandom(3, 10);
            System.out.println(Thread.currentThread().getName() + t);
            sleep(t, TimeUnit.SECONDS);
            return String.valueOf(t);
        });
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            int t = getRandom(3, 10);
            System.out.println(Thread.currentThread().getName() + t);
            sleep(t, TimeUnit.SECONDS);
            return String.valueOf(t);
        });
        CompletableFuture f3 = f1.applyToEither(f2, s -> s);
        System.out.println(Thread.currentThread().getName() + f3.join());
    }

    private static int getRandom(int a, int b) {
        return (int) (Math.random() * (b - a + 1)) + a;
    }

    private static void sleep(int t, TimeUnit unit) {
        try {
            unit.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
