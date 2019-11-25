package com.example.unnameddemo.push;

import java.io.UnsupportedEncodingException;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @author Gary
 * @className BatchPush
 * @description TODO
 * @date 2019/11/25 10:21
 **/
public class BatchPushTest {

    public static void batchPush() {

        // 创建批量推送的线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,
                2, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(50), new ThreadPoolExecutor.AbortPolicy());
        ;
        // 模拟推送列表
        List<String> list = Arrays.asList("mcn0001", "mcn0002", "mcn0004", "mcn0003", "mcn0001", "mcn0002", "mcn0002", "mcn0003");
        // 将推送列表去重
        List<String> distinct = list.stream().distinct().collect(Collectors.toList());

        // 定义一个 map 存放每个 mcn 的推送列表，key 为 mcn 名称，value 为该 mcn 的推送列表
        Map<String, List<String>> map = new HashMap<>(distinct.size());

        // 将不同 mcn 的推送列表分批存到 map 中
        distinct.forEach(item -> {
            List<String> collect = list.stream().filter(mcn -> mcn.equals(item)).collect(Collectors.toList());
            map.put(item, collect);
        });

        // 定义一个 list，用来存放异步返回结果
        List<FutureTask> futureTaskList = new ArrayList<>();
        // 循环 map，每一个 mcn 起一个线程
        for (String key : map.keySet()) {
            FutureTask<String> futureTask = new FutureTask<>(() -> {
                List<String> pushList = map.get(key);
                System.out.println(Thread.currentThread().getName() + "推送队列" + pushList + "---" + LocalTime.now());
                innerBatchPush(pushList);
                return pushList + "推送完毕---" + LocalTime.now();
            });
            // 任务提交给线程池
            executor.submit(futureTask);
            futureTaskList.add(futureTask);
        }
        // 取出执行结果
        futureTaskList.forEach(item -> {
            try {
                System.out.println(item.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

    }

    public static void innerBatchPush(List<String> list) {

        for (int i = 0; i < list.size(); i++) {
            System.out.println(Thread.currentThread().getName() + "推送" + list.get(i) + "---" + LocalTime.now());
            // 推送到最后一条不需要 sleep
            if (i != list.size() - 1) {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
//        batchPush();
        System.out.println("11".getBytes("gbk").length);
        System.out.println("好".getBytes("gbk").length);
    }


}
