package com.example.unnameddemo.prodconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者案例一
 *
 * @author Gary
 * @date 2020/3/12 15:44
 * @since jdk1.8
 **/
public class Demo01 {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                shareData.increasement();
            }
        }, "AAA");
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                shareData.decreasement();
            }
        }, "BBB");
        t1.start();
        t2.start();
    }
}

class ShareData {
    /**
     * 1. 线程操作资源类（资源类中有共享资源、锁）
     * 2. 判断 干活（方法）通知唤醒
     * 3. 防止虚假唤醒（判断都用while而不是if）
     */

    /**
     * 变量初始为0，两个线程交替加一减一
     */
    private int count = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increasement() {
        lock.lock();
        try {
            while (count != 0) {
                condition.await();
            }
            count++;
            System.out.println("我是线程" + Thread.currentThread().getName() + "\t" + count);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decreasement() {
        lock.lock();
        try {
            while (count == 0) {
                condition.await();
            }
            count--;
            System.out.println("我是线程" + Thread.currentThread().getName() + "\t" + count);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
