package com.example.unnameddemo.threadpoolexecutor;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Gary
 * @className Test
 * @description TODO
 * @date 2019-07-28 21:44
 **/
public class Test {

    private static BlockingQueue<Runnable> blockingDeque = new LinkedBlockingDeque<>();
    private static ThreadFactory threadFactory = new NameThreadFactory();
    private static RejectedExecutionHandler rejectedExecutionHandler = new MyIgnorePolicy();
    private static ThreadPoolExecutor threadPoolExecutor =
            new ThreadPoolExecutor(6, 6, 0,
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

    private static int count1 = 60000;
    private static int count2 = 600;

    public static void cal(){
        int sum = 0;
        for (int i = 0; i < 100000000; i++) {
            sum +=i;
        }
    }

    public static void task(List<Object> list) {
        list.forEach(a -> {
            cal();
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<List<Object>> list1 = new ArrayList<>(count1);
        for (int i = 0; i < count1; i++) {
            list1.add(Collections.singletonList(i));
        }
        List<Object> list2 = new ArrayList<>(count2);
        for (int i = 0; i < count2; i++) {
            list2.add(i);
        }

        ExecutorService es = Executors.newFixedThreadPool(6);
        ExecutorService es1 = Executors.newFixedThreadPool(256);
        CountDownLatch countDownLatch = new CountDownLatch(count1);
        long l = System.currentTimeMillis();
        for (int i = 0; i < count1; i++) {
            int i1 = i;
            es.execute(() -> {
                task(list1.get(i1));
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);

//        CountDownLatch countDownLatch1 = new CountDownLatch(count1);
//        long l2 = System.currentTimeMillis();
//        for (int i = 0; i < count1; i++) {
//            int i1 = i;
//            es1.execute(() -> {
//                task(list1.get(i1));
//                countDownLatch1.countDown();
//            });
//        }
//        countDownLatch1.await();
//        long l3 = System.currentTimeMillis();
//        System.out.println(l3 - l2);

        CountDownLatch countDownLatch1 = new CountDownLatch(100);
        long l2 = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.execute(() -> {
                task(list2);
                countDownLatch1.countDown();
            });
        }
        countDownLatch1.await();
        long l3 = System.currentTimeMillis();
        System.out.println(l3 - l2);

        es.shutdown();
        es1.shutdown();

//        test();

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
