package com.example.structurealgorithmdemo.linkedlist;

/**
 * 双端链表测试
 *
 * @author Gary
 * @date 2019/12/8 18:12
 * @since jdk1.8
 **/
public class DoublePointLinkedListTest {

    public static void main(String[] args) {
        DoublePointLinkedList dp = new DoublePointLinkedList();
        dp.addHead("A");
        dp.addHead("B");
        dp.addHead("C");
        dp.addHead("D");
        dp.addHead("E");
        dp.getAll();

        dp.addTail("F");
        dp.getAll();

        dp.removeHead();
        dp.getAll();
    }
}
