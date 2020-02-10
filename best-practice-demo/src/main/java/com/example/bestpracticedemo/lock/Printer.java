package com.example.bestpracticedemo.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 交替执行
 *
 * @author Gary
 * @date 2020/1/14 14:17
 * @since jdk1.8
 **/
public class Printer {

    public static void main(String[] args) throws InterruptedException {
        print();
    }

    public static void print() throws InterruptedException {

        Lock lock = new ReentrantLock();
        Condition cond1 = lock.newCondition();
//        Condition cond2 = lock.newCondition();

        Thread t1 = new Thread(() -> {
            int count = 0;
            try {
                lock.lock();
                while (count < 10) {
                    System.out.println(1);
                    cond1.signalAll();
                    cond1.await();
                    count++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }, "T1");

//        TimeUnit.MICROSECONDS.sleep(500);

        Thread t2 = new Thread(() -> {
            int count = 0;

            try {
                lock.lock();
                while (count < 10) {
                    System.out.println(2);
                    cond1.signalAll();
                    cond1.await();
                    count++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "T2");
        t1.start();
        t2.start();
    }
}
