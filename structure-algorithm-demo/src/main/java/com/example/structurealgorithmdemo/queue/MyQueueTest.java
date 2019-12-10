package com.example.structurealgorithmdemo.queue;

/**
 * 队列测试
 *
 * @author Gary
 * @date 2019/12/10 10:47
 * @since jdk1.8
 **/
public class MyQueueTest {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue(3);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        // [1,2,3] 队头是 1
        queue.display();

        System.out.println(queue.peekFront());
        System.out.println(queue.remove());
        // [null,2,3] 队头是 2，队尾是 3
        queue.display();

        System.out.println(queue.peekFront());

        queue.insert(4);
        // [4,2,3] 队头是 2，队尾是 4
        queue.display();

        System.out.println(queue.peekFront());
        queue.insert(5);
        // 队列已满
    }
}
