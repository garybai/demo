package com.example.unnameddemo.prodconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者案例二
 *
 * @author Gary
 * @date 2020/3/12 16:06
 * @since jdk1.8
 **/
public class Demo02 {
    public static void main(String[] args) {
        ShareResource resource = new ShareResource();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                resource.printA();
            }
        }, "AAA").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                resource.printB();
            }
        }, "BBB").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                resource.printC();
            }
        }, "CCC").start();
    }
}

class ShareResource {

    /**
     * 3个线程，依次打印AA BB CC
     */
    private volatile int flag = 1; // 1 AA 2 BB 3 CC
    private Lock lock = new ReentrantLock();
    Condition aa = lock.newCondition();
    Condition bb = lock.newCondition();
    Condition cc = lock.newCondition();

    public void printA() {
        lock.lock();
        try {
            while (flag != 1) {
                aa.await();
            }
            System.out.println("AA");
            flag = 2;
            bb.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        lock.lock();
        try {
            while (flag != 2) {
                bb.await();
            }
            System.out.println("BB");
            flag = 3;
            cc.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        try {
            while (flag != 3) {
                cc.await();
            }
            System.out.println("CC");
            flag = 1;
            aa.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
