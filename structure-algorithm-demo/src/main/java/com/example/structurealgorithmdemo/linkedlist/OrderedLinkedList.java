package com.example.structurealgorithmdemo.linkedlist;

/**
 * 有序链表
 *
 * @author Gary
 * @date 2019/12/8 19:16
 * @since jdk1.8
 **/
public class OrderedLinkedList {

    private Node head;

    private static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public OrderedLinkedList() {
        head = null;
    }

    /**
     * 插入元素，并按照从小到大的顺序排列
     *
     * @param value
     */
    public void insert(int value) {
        Node node = new Node(value);
        Node prev = null;
        Node curr = head;
        /**
         * 从头开始遍历找到新节点应该插入的位置，找到它的 prev 和 next
         */
        while (curr != null && value > curr.data) {
            prev = curr;
            curr = curr.next;
        }
        if (prev == null) {
            head = node;
            head.next = curr;
        } else {
            prev.next = node;
            node.next = curr;
        }
    }

    /**
     * 删除头节点
     */
    public void removeHead() {
        head = head.next;
    }

    public void display() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println("");
    }
}
