package com.example.unnameddemo.prodconsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 自己实现一个阻塞队列
 *
 * @author Gary
 * @date 2020/3/12 17:00
 * @since jdk1.8
 **/
public class Demo04 {

    public static void main(String[] args) throws InterruptedException {
        MyQueue queue = new MyQueue();

        Runnable runProduce = () -> {
            int count = 2;
            while (count-- > 0) {
                queue.produce();
            }
        };
        Runnable runConsume = () -> {
            int count = 2;
            while (count-- > 0) {
                queue.consume();
            }
        };

        for (int i = 0; i < 2; i++) {
            new Thread(runProduce).start();
        }

        TimeUnit.SECONDS.sleep(3);

        for (int i = 0; i < 5; i++) {
            new Thread(runConsume).start();
        }
    }

}

class MyQueue {

    Buffer buffer = new Buffer();

    private Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public void produce() {
        lock.lock();
        try {
            while (buffer.isFull()) {
                notFull.await();
            }
            buffer.add();
            notEmpty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void consume() {
        lock.lock();
        try {
            while (buffer.isEmpty()) {
                notEmpty.await();
            }
            buffer.remove();
            notFull.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private static class Buffer {
        private static final int MAX_CAPATICY = 3;
        private List<Object> data = new ArrayList<>(MAX_CAPATICY);

        void add() {
            if (isFull()) {
                throw new IndexOutOfBoundsException();
            }
            data.add(new Object());
            System.out.println(Thread.currentThread().getName() + "\tadd");
        }

        void remove() {
            if (isEmpty()) {
                throw new IndexOutOfBoundsException();
            }
            data.remove(data.size() - 1);
            System.out.println(Thread.currentThread().getName() + "\tremove");
        }

        boolean isEmpty() {
            return data.isEmpty();
        }

        boolean isFull() {
            return data.size() == MAX_CAPATICY;
        }
    }
}
