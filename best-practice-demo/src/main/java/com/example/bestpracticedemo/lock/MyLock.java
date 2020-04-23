package com.example.bestpracticedemo.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock 测试
 *
 * @author Gary
 * @date 2019/12/15 15:15
 * @since jdk1.8
 **/
public class MyLock {

    public static void main(String[] args) {
        MyLock myLock = new MyLock();
        Runnable runProduce = () -> {
            int count = 2;
            while (count-- >0){
                myLock.produce();
            }
        };
        Runnable runConsume = () ->{
            int count = 2;
            while (count-- >0){
                myLock.consume();
            }
        };

        for (int i = 0; i < 2; i++) {
            new Thread(runConsume).start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(runProduce).start();
        }
    }

    Buffer buffer = new Buffer();
    final ReentrantLock lock = new ReentrantLock();
    /**
     * 入队的等待条件，队列不满
     */
    final Condition notFull = lock.newCondition();

    /**
     * 出队的等待条件，队列不空
     */
    final Condition notEmpty = lock.newCondition();

    public void produce() {
        lock.lock();
        try {
            while (buffer.isFull()) {
                try {
                    // 如果队列已满，开始等待
                    notFull.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 队列不满之后跳出循环，执行入队
            buffer.add();
            // 入队完成，通知在等待队列不空这个条件的线程
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void consume() {
        lock.lock();
        try {
            while (buffer.isEmpty()) {
                try {
                    // 如果队列为空，则开始等待
                    notEmpty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 队列非空，跳出循环，执行出队
            buffer.remove();
            // 出队后，通知在等待队列不满这个条件的线程
            notFull.signalAll();
        } finally {
            lock.unlock();
        }
    }

    private static class Buffer {
        private static final int MAX_CAPACITY = 1;
        private List<Object> innerList = new ArrayList<>(MAX_CAPACITY);

        void add() {
            if (isFull()) {
                throw new IndexOutOfBoundsException();
            } else {
                innerList.add(new Object());
            }
            System.out.println(Thread.currentThread().getName() + " add");
        }

        void remove() {
            if (isEmpty()) {
                throw new IndexOutOfBoundsException();
            } else {
                innerList.remove(MAX_CAPACITY - 1);
            }
            System.out.println(Thread.currentThread().getName() + " remove");
        }

        boolean isEmpty() {
            return innerList.isEmpty();
        }

        boolean isFull() {
            return innerList.size() == MAX_CAPACITY;
        }
    }
}
