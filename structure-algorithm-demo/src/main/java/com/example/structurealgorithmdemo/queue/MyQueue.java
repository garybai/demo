package com.example.structurealgorithmdemo.queue;

import java.util.Arrays;

/**
 * 队列代码实现
 *
 * @author Gary
 * @date 2019/12/10 10:22
 * @since jdk1.8
 **/
public class MyQueue {
    /**
     * 存放数据的数组
     */
    private Object[] queueArray;
    /**
     * 队列最大长度
     */
    private int maxSize;
    /**
     * 队列头部指针
     */
    private int front;
    /**
     * 队列尾部指针
     */
    private int rear;
    /**
     * 当前队列长度
     */
    private int nItems;

    /**
     * 构造方法初始化队列
     * @param maxSize
     */
    public MyQueue(int maxSize) {
        this.queueArray = new Object[maxSize];
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = -1;
        this.nItems = 0;
    }

    /**
     * 插入数据到队列尾部
     * @param object
     */
    public void insert(Object object) {
        // 如果队列已满
        if (isFull()) {
            System.out.println("队列已满！");
        }
        // 如果队尾指针指向顶部，则循环回来
        if (rear == maxSize - 1) {
            rear = -1;
        }
        // 队尾指针加 1，然后在队尾指针出插入数据
        queueArray[++rear] = object;
        nItems++;
    }

    /**
     * 从队列头部移除数据
     * @return
     */
    public Object remove() {
        Object removeValue = null;
        if (!isEmpty()) {
            removeValue = queueArray[front];
            queueArray[front] = null;
            // 队头指针上移
            front++;
            // 对头指针若移到队列顶部，则循环回来
            if (front == maxSize) {
                front = 0;
            }
            nItems--;
        }
        return removeValue;
    }

    /**
     * 队列是否已满
     * @return
     */
    public boolean isFull() {
        return nItems == maxSize;
    }

    /**
     * 队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return nItems == 0;
    }

    /**
     * 返回队列头部数据
     * @return
     */
    public Object peekFront() {
        return queueArray[front];
    }

    /**
     * 返回队列当前长度
     * @return
     */
    public int getSize() {
        return nItems;
    }

    public void display(){
        Arrays.stream(queueArray).forEach(System.out::print);
        System.out.println();
    }

}
