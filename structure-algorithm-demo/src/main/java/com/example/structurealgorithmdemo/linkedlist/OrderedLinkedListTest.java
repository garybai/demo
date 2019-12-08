package com.example.structurealgorithmdemo.linkedlist;

/**
 * 有序链表测试
 *
 * @author Gary
 * @date 2019/12/8 19:37
 * @since jdk1.8
 **/
public class OrderedLinkedListTest {
    public static void main(String[] args) {
        OrderedLinkedList orderedLinkedList = new OrderedLinkedList();
        orderedLinkedList.insert(4);
        orderedLinkedList.insert(10);
        orderedLinkedList.insert(2);
        orderedLinkedList.insert(6);
        orderedLinkedList.insert(1);
        orderedLinkedList.display();

        orderedLinkedList.removeHead();
        orderedLinkedList.display();
    }
}
