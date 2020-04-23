package com.example.unnameddemo.prodconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者消费者案例三
 *
 * @author Gary
 * @date 2020/3/12 16:27
 * @since jdk1.8
 **/
public class Demo03 {
    public static void main(String[] args) throws InterruptedException {
        MyResource resource = new MyResource(new ArrayBlockingQueue<>(3));
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"生产线程启动");
            try {
                resource.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Prod").start();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"消费线程启动");
            try {
                resource.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Consumer").start();

        TimeUnit.SECONDS.sleep(4);
        resource.stop();
    }
}

class MyResource {
    private volatile boolean flag = true; // 默认开启生产+消费
    private AtomicInteger integer = new AtomicInteger();

    private BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void produce() throws InterruptedException {
        String data;
        boolean returnValue;
        while (flag) {
            data = integer.incrementAndGet() + "";
            returnValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (returnValue) {
                System.out.println(Thread.currentThread().getName() + "生产成功\t" + data);
            } else {
                System.out.println(Thread.currentThread().getName() + "生产失败\t" + data);
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "生产结束");
    }

    public void consumer() throws InterruptedException {
        String result;
        while (flag) {
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (result == null || "".equalsIgnoreCase(result)) {
                flag = false;
                System.out.println(Thread.currentThread().getName() + "超过2秒没有取到，停止消费");
                return;
            }
            System.out.println(Thread.currentThread().getName() + "消费成功\t" + result);
        }
    }

    public void stop(){
        this.flag = false;
    }

}
