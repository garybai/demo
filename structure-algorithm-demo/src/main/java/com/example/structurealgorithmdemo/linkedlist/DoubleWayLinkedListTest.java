package com.example.structurealgorithmdemo.linkedlist;

/**
 * 双向链表测试
 *
 * @author Gary
 * @date 2019/12/8 22:38
 * @since jdk1.8
 **/
public class DoubleWayLinkedListTest {

    public static void main(String[] args) {
        DoubleWayLinkedList linkedList = new DoubleWayLinkedList();
        linkedList.addHead("A");
        linkedList.addHead("B");
        linkedList.addHead("C");
        linkedList.display();

        linkedList.addTail("D");
        linkedList.addTail("E");
        linkedList.display();

        linkedList.removeHead();
        linkedList.display();
        linkedList.removeTail();
        linkedList.display();
    }
}
