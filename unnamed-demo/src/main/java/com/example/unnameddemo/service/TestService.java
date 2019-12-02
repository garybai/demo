package com.example.unnameddemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Gary
 * @className TestService
 * @description TODO
 * @date 2019/11/22 12:02
 **/
public class TestService {


    ExecutorService executorService = Executors.newFixedThreadPool(5);
    private static List<Integer> list = new ArrayList<>();

    public static  void init(){
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
    }
    private static void test1() {
        list.forEach(item -> {
            try {
                System.out.println(doTask(item));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private static String doTask(int a) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(20);
        return a + "done" + Thread.currentThread().getName();
    }

    private static void test2() {
        list.stream().parallel().forEach(item -> {
            try {
                System.out.println(doTask(item));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }


    public static void main(String[] args) {
        init();
        long a = System.currentTimeMillis();
        test1();
        long b = System.currentTimeMillis();
        System.out.println(b - a);
        test2();
        long c = System.currentTimeMillis();
        System.out.println(c - b);
    }


}
