package com.example.bestpracticedemo.completablefuture;

import com.example.bestpracticedemo.threadpool.MyThreadFactory;

import java.time.LocalTime;
import java.util.StringJoiner;
import java.util.concurrent.*;

/**
 * 吃饭
 *
 * @author Gary
 * @date 2022/9/10 下午4:21
 **/
public class ChiFanTask {

    private static ThreadPoolExecutor executor =
            new ThreadPoolExecutor(3, 3, 5, TimeUnit.SECONDS,
                    new ArrayBlockingQueue<>(10), new MyThreadFactory(), new ThreadPoolExecutor.AbortPolicy()
            );

    public static void main(String[] args) throws Exception {
//        demo1();
//        demo2();
//        demo21();
//        demo22();
//        demo3();
        demo4();
        executor.shutdown();

    }

    /**
     * 厨师炒菜和米饭异步处理
     * 小白是main线程，厨师是另外线程池
     *
     * @param :
     * @return void
     * @author: Gary
     * @date: 2022/9/11 上午9:40
     */
    private static void demo1() {
        print("小白进入餐厅");
        print("小白开始点菜：番茄炒蛋+一碗米饭");
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            print("厨师开始炒菜");
            sleep(2, TimeUnit.SECONDS);
            print("厨师炒菜完成");
            print("厨师开始打饭");
            sleep(1, TimeUnit.SECONDS);
            print("厨师打饭完成");
            return "番茄炒蛋+米饭做好了";
        }, executor);
        print("小白开始打王者");
        print(String.format("%s，小白开吃", cf.join()));
    }

    /**
     * 厨师炒菜和服务员打饭异步完成，并且服务员打饭在厨师炒菜之后
     *
     * @param :
     * @return void
     * @author: Gary
     * @date: 2022/9/11 上午10:03
     */
    private static void demo2() {
        print("小白进入餐厅");
        print("小白开始点菜：番茄炒蛋+一碗米饭");
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            print("厨师开始炒菜");
            sleep(2, TimeUnit.SECONDS);
            print("厨师炒菜完成");
            return "番茄炒蛋";
        }, executor).thenCompose(dish -> CompletableFuture.supplyAsync(() -> {
            // thenCompose 是上一个任务完成之后，这一个任务才开始
            print("服务员开始打饭");
            sleep(1, TimeUnit.SECONDS);
            print("服务员打饭完成");
            return dish + "+米饭做好了";
        }, executor));
        print("小白开始打王者");
        print(String.format("%s，小白开吃", cf.join()));
    }

    private static void demo21() {
        print("小白进入餐厅");
        print("小白开始点菜：番茄炒蛋+一碗米饭");
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            print("厨师开始炒菜");
            sleep(2, TimeUnit.SECONDS);
            print("厨师炒菜完成");
            return "番茄炒蛋";
        }, executor).thenApplyAsync(dish -> {
            // thenApplyAsync 是上一个任务完成之后，这一个任务才开始，直接将上一个任务的结果传进来
            print("服务员开始打饭");
            sleep(1, TimeUnit.SECONDS);
            print("服务员打饭完成");
            return dish + "+米饭做好了";
        }, executor).exceptionally(e -> "发生异常了");
        print("小白开始打王者");
        print(String.format("%s，小白开吃", cf.join()));
    }

    private static void demo22() {
        print("小白进入餐厅");
        print("小白开始点菜：番茄炒蛋+一碗米饭");
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            print("厨师开始炒菜");
            sleep(2, TimeUnit.SECONDS);
            print("厨师炒菜完成");
            return "番茄炒蛋";
        }, executor).thenComposeAsync(dish -> {
            print("服务员开始打饭");
            return CompletableFuture.supplyAsync(() -> {
                sleep(1, TimeUnit.SECONDS);
                print("服务员打饭完成");
                return dish + "米饭";
            }, executor);
        });
        print("小白开始打王者");
        print(String.format("%s，小白开吃", cf.join()));
    }

    private static void demo3() {
        print("小白进入餐厅");
        print("小白开始点菜：番茄炒蛋+一碗米饭");
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            print("厨师开始炒菜");
            sleep(1, TimeUnit.SECONDS);
            print("厨师炒菜完成");
            return "番茄炒蛋";
        }, executor).thenCombine(CompletableFuture.supplyAsync(() -> {
            // thenCombine 两个任务同时开始
            print("服务员开始蒸饭");
            sleep(2, TimeUnit.SECONDS);
            print("服务员蒸饭完成");
            return "米饭";
        }, executor), (dish, rice) -> {
            // 将两个任务的结果进行处理
            print("服务员开始打饭");
            sleep(1, TimeUnit.SECONDS);
            print("服务员打饭完成");
            return String.format("%s+%s做好了", dish, rice);
        });
        print("小白开始打王者");
        print(String.format("%s，小白开吃", cf.join()));
    }

    private static void demo4() throws ExecutionException, InterruptedException {
        print("小白进入餐厅");
        print("小白开始点菜：番茄炒蛋+一碗米饭");
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            print("厨师开始炒菜");
            sleep(5, TimeUnit.SECONDS);
            print("厨师炒菜完成");
            return "番茄炒蛋";
        }, executor).exceptionally(e -> "厨师炒菜发生故障");
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            print("服务员1开始蒸饭");
            sleep(3, TimeUnit.SECONDS);
            print("服务员1蒸饭完成");
            return "米饭";
        }, executor).exceptionally(e -> "服务员1蒸饭故障");
        CompletableFuture<Void> cf3 = CompletableFuture.runAsync(() -> {
            print("服务员2开始打扫");
            sleep(2, TimeUnit.SECONDS);
            print("服务员2打扫完成");
        }, executor).exceptionally(e -> null);
        print("小白开始打王者");
        CompletableFuture<Void> allOf = CompletableFuture.allOf(cf1, cf2, cf3);
        allOf.get();

//        String dish = cf1.join();
//        String rice = cf2.join();
//        cf3.join();
//
        print(String.format("%s+%s做好了，小白开吃", cf1.get(), cf2.get()));
    }

    private static void print(String tag) {
        String s = new StringJoiner("\t|\t")
                .add(LocalTime.now().toString())
                .add(String.valueOf(Thread.currentThread().getId()))
                .add(Thread.currentThread().getName())
                .add(tag).toString();
        System.out.println(s);
    }

    private static void sleep(int n, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
