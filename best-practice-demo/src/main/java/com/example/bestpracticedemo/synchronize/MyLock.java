package com.example.bestpracticedemo.synchronize;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * synchronized 测试
 *
 * @author Gary
 * @date 2019/12/14 21:39
 * @since jdk1.8
 **/
public class MyLock {

    public static void main(String[] args) throws InterruptedException {
        Account src = new Account(10000);
        Account tar = new Account(10000);
        CountDownLatch latch = new CountDownLatch(9999);
        for (int i = 0; i < 9999; i++) {
            new Thread(() ->{
                src.transfer(1, tar);
                latch.countDown();
            }).start();
        }
        latch.await();
        System.out.println("src: " + src.getBalance());
        System.out.println("tar: " + tar.getBalance());
    }

    static class Account {
        private Integer balance;

        public Account(Integer balance) {
            this.balance = balance;
        }

        public void transfer(Integer money, Account target) {
            // 同时获得两个资源，避免死锁
            Allocator.getInstance().apply(this, target);
            this.balance -= money;
            target.setBalance(target.getBalance() + money);
            Allocator.getInstance().release(this, target);
        }

        public Integer getBalance() {
            return balance;
        }

        public void setBalance(Integer balance) {
            this.balance = balance;
        }
    }

    static class Allocator {
        // 必须单例模式
        private Allocator() {
        }

        // 存放被锁的账户
        private List<Account> accountLocks = new ArrayList<>();

        public synchronized void apply(Account src, Account tar) {
            while (accountLocks.contains(src) || accountLocks.contains(tar)) {
                try {
                    // 如果条件未满足则开始等待，并释放资源
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            accountLocks.add(src);
            accountLocks.add(tar);
        }

        public synchronized void release(Account src, Account tar) {
            accountLocks.remove(src);
            accountLocks.remove(tar);
            // 通知其他线程
            this.notifyAll();
        }

        public static Allocator getInstance() {
            return AllocatorSingle.install;
        }

        static class AllocatorSingle {
            public static Allocator install = new Allocator();
        }
    }
}
