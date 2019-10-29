package com.example.concurrentdemo.demo;

/**
 * @author Gary
 * @className ThreadPrint99
 * @description TODO
 * @date 2019-09-26 11:05
 **/
public class ThreadPrint99 {

    private static int totalNum = 0;

    public static void main(String[] args) {
        Object lock = new Object();

        for (int i = 1; i <= 99; i++) {

            int num = i;

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        synchronized (lock) {
                            while (totalNum != num) {
                                lock.wait();
                            }
                            System.out.println(Thread.currentThread().getName() + " : " + num);
                            totalNum++;
                            lock.notifyAll();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }, "thread-" + num);
            thread.start();
        }
        synchronized (lock) {
            totalNum = totalNum + 1;
            lock.notifyAll();
        }
    }
}
