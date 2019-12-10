package com.example.structurealgorithmdemo.queue;

/**
 * 优先级队列测试
 *
 * @author Gary
 * @date 2019/12/10 11:10
 * @since jdk1.8
 **/
public class MyPriorityQueueTest {
    public static void main(String[] args) {
        MyPriorityQueue queue = new MyPriorityQueue(5);
        queue.insert(3);
        queue.insert(1);
        queue.insert(5);
        queue.display();
        queue.insert(8);
        queue.insert(2);
        queue.display();

        System.out.println(queue.peekMin());

    }
}
