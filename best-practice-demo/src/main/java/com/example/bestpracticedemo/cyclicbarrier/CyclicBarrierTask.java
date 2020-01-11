package com.example.bestpracticedemo.cyclicbarrier;

import java.time.LocalTime;
import java.util.Vector;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * CyclicBarrier测试
 *
 * @author Gary
 * @date 2019/12/7 11:22
 * @since jdk1.8
 **/
class CyclicBarrierTask {

    /**
     * 两个队列存放订单和派送单
     */
    private Vector<String> pos;
    private Vector<String> dos;
    /**
     * 执行查询订单和派送单的线程池
     */
    private ExecutorService es = Executors.newFixedThreadPool(2);
    /**
     * 执行 check 和 save 的线程池
     * 这里只能创建一个线程
     */
    private ExecutorService es1 = Executors.newFixedThreadPool(1);
    /**
     * CyclicBarrier 初始值为 2，计数器为 0 时回调方法是 check()
     */
    private CyclicBarrier barrier = new CyclicBarrier(2, () -> {
        es1.execute(this::check);
    });

    CyclicBarrierTask(Vector<String> pos, Vector<String> dos) {
        this.pos = pos;
        this.dos = dos;
    }

    void checkAll() {
        AtomicInteger i = new AtomicInteger();
        AtomicInteger j = new AtomicInteger();
        /**
         * 查询订单，并把订单放入订单队列
         */
        es.execute(() -> {
            while (i.get() < 5) {
                pos.add(getPOrders());
                try {
                    /**
                     * 等待另一个线程结束
                     */
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                i.incrementAndGet();
            }
        });
        /**
         * 查询派送单，并把派送单放入派送单队列
         */
        es.execute(() -> {
            while (j.get() < 5) {
                dos.add(getDOrders());
                try {
                    /**
                     * 等待另一个线程结束
                     */
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                j.incrementAndGet();
            }
        });
    }

    private void sleep(Integer timeout) {
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String getPOrders() {
        System.out.println(Thread.currentThread().getName() + "开始执行getPOrders " + LocalTime.now());
        sleep(3);
        System.out.println(Thread.currentThread().getName() + "执行getPOrders完毕 " + LocalTime.now());
        return "p";
    }

    private String getDOrders() {
        System.out.println(Thread.currentThread().getName() + "开始执行getDOrders " + LocalTime.now());
        sleep(5);
        System.out.println(Thread.currentThread().getName() + "执行getDOrders完毕 " + LocalTime.now());
        return "d";
    }

    private void check() {
        System.out.println(Thread.currentThread().getName() + "开始执行check " + LocalTime.now());
        /**
         * 从两个队列取出订单和派送单进行 check
         */
        String p, d;
        synchronized (this){
            p = pos.remove(0);
            d = dos.remove(0);
        }
        sleep(1);
        System.out.println(Thread.currentThread().getName() + "执行check完毕 " + p + d + LocalTime.now());
        save();
    }

    private void save() {
        System.out.println(Thread.currentThread().getName() + "开始执行save " + LocalTime.now());
        sleep(1);
        System.out.println(Thread.currentThread().getName() + "执行save完毕 " + LocalTime.now());
    }
}
