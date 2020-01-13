package com.example.bestpracticedemo.synchronize;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试
 *
 * @author Gary
 * @date 2019/12/14 22:37
 * @since jdk1.8
 **/
public class AnotherLock {

    private Buffer buffer = new Buffer();

    public static void main(String[] args) {
        AnotherLock lock = new AnotherLock();
        Runnable runProduce = () -> {
            int count = 2;
            while (count-- >0){
                lock.produce();
            }
        };
        Runnable runConsume = () ->{
            int count = 2;
            while (count-- >0){
                lock.consume();
            }
        };

        for (int i = 0; i < 2; i++) {
            new Thread(runConsume).start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(runProduce).start();
        }
    }

    public void produce() {
        synchronized (this){
            while (buffer.isFull()){
                try {
                    // 如果队列已满，则开始等待，并释放资源
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            buffer.add();
            // 添加成功后通知其他线程
            notifyAll();
        }
    }

    public void consume() {
        synchronized (this){
            while (buffer.isEmpty()){
                try {
                    // 如果队列为空，开始等待，并释放资源
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            buffer.remove();
            // 消费成功后通知其他线程
            notifyAll();
        }
    }

    private class Buffer{
        private static final int MAX_CAPACITY = 1;
        private List<Object> innerList = new ArrayList<>(MAX_CAPACITY);

        void add(){
            if (isFull()){
                throw new IndexOutOfBoundsException();
            } else {
                innerList.add(new Object());
            }
            System.out.println(Thread.currentThread().getName() + " add");
        }

        void remove(){
            if (isEmpty()){
                throw new IndexOutOfBoundsException();
            }else {
                innerList.remove(MAX_CAPACITY - 1);
            }
            System.out.println(Thread.currentThread().getName() + " remove");
        }
        boolean isEmpty(){
            return innerList.isEmpty();
        }
        boolean isFull(){
            return innerList.size() == MAX_CAPACITY;
        }
    }
}
