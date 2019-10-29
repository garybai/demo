package com.example.unnameddemo.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author Gary
 * @className AsyncController
 * @description TODO
 * @date 2019-07-29 23:11
 **/
@RestController
@RequestMapping("async")
public class AsyncController {

    @Autowired
    private AsyncTask asyncTask;

    @RequestMapping("test")
    public void doTask() throws InterruptedException, ExecutionException {
        long a = System.currentTimeMillis();
        Future<String> task1 = asyncTask.task1();
        Future<String> task2 = asyncTask.task2();
        Future<Integer> task3 = asyncTask.task3();
//        while (true) {
//            if (task1.isDone() && task2.isDone() && task3.isDone()) {
//                break;
//            }
//            Thread.sleep(500);
//        }
        String s1 = task1.get();
        String s2 = task2.get();
        Integer s3 = task3.get();

        System.out.println(s1 + " " + s2 + " " + s3);

        long b = System.currentTimeMillis();
        System.out.println("任务执行" + (b - a) + "ms");

    }
}
