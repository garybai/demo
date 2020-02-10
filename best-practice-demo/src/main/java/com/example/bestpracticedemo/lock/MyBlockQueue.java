package com.example.bestpracticedemo.lock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自己实现阻塞队列
 *
 * @author Gary
 * @date 2020/2/3 16:05
 * @since jdk1.8
 **/
public class MyBlockQueue {

    public static void main(String[] args) throws InterruptedException {
        MyResource resource = new MyResource(new ArrayBlockingQueue<>(10));
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t生产线程启动");
            try {
                resource.prod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "生产线程").start();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t消费线程启动");
            try {
                resource.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "消费线程").start();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("5秒钟时间到");
        resource.stop();
    }

}

class MyResource{
    /**
     * 默认开启生产消费
     */
    private volatile boolean FLAG = true;

    private AtomicInteger integer = new AtomicInteger();

    BlockingQueue<String> blockingQueue;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void prod() throws InterruptedException {
        String data;
        boolean returnValue;
        while (FLAG){
            data = integer.incrementAndGet()+"";
            returnValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (returnValue) {
                System.out.println(Thread.currentThread().getName() + "\t插入队列成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t插入队列失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "\t停止生产");
    }

    public void consume() throws InterruptedException{
        String result;
        while (FLAG){
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (null==result||"".equals(result)){
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t消费退出");
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t消费队列成功");
        }
    }

    public void stop(){
        this.FLAG = false;
    }
}
