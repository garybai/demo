package com.example.concurrentdemo.demo;

/**
 * @author Gary
 * @className Test01
 * @description TODO
 * @date 2019-09-24 10:16
 **/
public class Test01 {


    private long count = 0;

    private void add10K() {
        int idx = 0;
        while (idx++ < 10000) {
            count += 1;
        }
    }

    public static long calc() throws Exception {
        Test01 test = new Test01();
        // 创建两个线程，执行 add() 操作
        Thread th1 = new Thread(() -> {
            System.out.println("111");
            test.add10K();
        });
        Thread th2 = new Thread(() -> {
            System.out.println("222");
            test.add10K();
        });
        // 启动两个线程
        System.out.println(th1.getName());
        th1.start();
        System.out.println(th2.getName());
        th2.start();
        // 等待两个线程执行结束
        th1.join();
        th2.join();
        return test.count;
    }

    public static void main(String[] args) throws Exception {
        long result = calc();
        System.out.println(result);
    }


}
