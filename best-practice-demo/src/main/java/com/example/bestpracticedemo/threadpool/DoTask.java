package com.example.bestpracticedemo.threadpool;

import java.time.LocalTime;
import java.util.concurrent.*;

/**
 * 泡茶
 *
 * @author Gary
 * @date 2019/11/26 16:41
 * @since jdk1.8
 **/
public class DoTask {

    private static ThreadPoolExecutor executor =
            new ThreadPoolExecutor(2, 2, 5, TimeUnit.SECONDS,
                    new ArrayBlockingQueue<>(10), new MyThreadFactory(), new ThreadPoolExecutor.AbortPolicy()
            );

    private static void doTea() throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask1 = new FutureTask<>(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + "洗茶壶……" + LocalTime.now());
            TimeUnit.SECONDS.sleep(1);

            System.out.println(threadName + "洗茶杯……" + LocalTime.now());
            TimeUnit.SECONDS.sleep(3);

            System.out.println(threadName + "拿茶叶……" + LocalTime.now());
            TimeUnit.SECONDS.sleep(1);

            return "龙井";
        });


        FutureTask<String> futureTask2 = new FutureTask<>(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + "洗水壶……" + LocalTime.now());
            TimeUnit.SECONDS.sleep(1);

            System.out.println(threadName + "烧开水……" + LocalTime.now());
            TimeUnit.SECONDS.sleep(2);

            // 需要等待 futureTask1 执行完才能执行，这里会阻塞
            String s = futureTask1.get();
            System.out.println("拿到" + s + LocalTime.now());

            System.out.println(threadName + "泡茶……" + LocalTime.now());
            TimeUnit.SECONDS.sleep(1);

            return "上茶：" + s + LocalTime.now();
        });

        executor.submit(futureTask1);
        TimeUnit.MILLISECONDS.sleep(500);
        executor.submit(futureTask2);
        System.out.println(futureTask2.get());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        doTea();
        executor.shutdown();
    }
}
