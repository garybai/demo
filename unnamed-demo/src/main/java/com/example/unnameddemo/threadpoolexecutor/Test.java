package com.example.unnameddemo.threadpoolexecutor;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Gary
 * @className Test
 * @description TODO
 * @date 2019-07-28 21:44
 **/
public class Test {

    private static BlockingQueue<Runnable> blockingDeque = new LinkedBlockingDeque<>(10);
    private static ThreadFactory threadFactory = new NameThreadFactory();
    private static RejectedExecutionHandler rejectedExecutionHandler = new MyIgnorePolicy();
    private static ThreadPoolExecutor threadPoolExecutor =
            new ThreadPoolExecutor(5, 10, 10,
                    TimeUnit.SECONDS, blockingDeque, threadFactory, rejectedExecutionHandler);

    private static void test() throws ExecutionException, InterruptedException {

        List<FutureTask<String>> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            FutureTask<String> futureTask = new FutureTask<>(() -> {
                String name = Thread.currentThread().getName();
                System.out.println("thread " + name + " start" + LocalTime.now());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("thread " + name + " interrupted" + LocalTime.now());
                }
                System.out.println("thread " + name + " end" + LocalTime.now());
                return name + " executing" + LocalTime.now();
            });

            threadPoolExecutor.submit(futureTask);
            list.add(futureTask);
        }

        list.forEach(s -> {
            try {
                System.out.println(s.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        test();

//        for (int i = 1; i <= 10; i++) {
//            Runnable runnable = new TaskWithoutResult(String.valueOf(i));
//            threadPoolExecutor.execute(runnable);
//        }

//        List<Future<String>> futureList = new ArrayList<>();
//        StringBuilder s = new StringBuilder();
//        for (int i = 0; i < 10; i++) {
//            Callable<String> callable = new TaskWithResult(String.valueOf(i));
//            Future<String> future = threadPoolExecutor.submit(callable);
//            futureList.add(future);
//        }
//
//        for (Future<String> future : futureList) {
//            try {
//                s.append(future.get(2, TimeUnit.SECONDS));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                System.err.println("执行异常");
//            } catch (TimeoutException e) {
//                System.err.println("等待超时");
//            }
//        }
//
//        System.out.println(s.toString());

//        futureList.forEach(row -> {
//            try {
//                s += row.get();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//        });


//        Runnable runnable = ()->{
//            try {
//                System.out.println("thread " + Thread.currentThread().getName() + " start");
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                System.out.println("thread " + Thread.currentThread().getName() + " interrupted");
//            }
//            System.out.println("thread " + Thread.currentThread().getName() + " end");
//        };
//
//        for (int i = 0; i < 10; i++) {
//            threadPoolExecutor.execute(runnable);
//        }
//        threadPoolExecutor.shutdown();

    }

}
