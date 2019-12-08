package com.example.structurealgorithmdemo.linkedlist;

/**
 * 双端链表
 *
 * @author Gary
 * @date 2019/12/8 17:31
 * @since jdk1.8
 **/
public class DoublePointLinkedList {

    /**
     * 链表头节点
     */
    private Node head;
    /**
     * 链表尾节点
     */
    private Node tail;
    /**
     * 链表长度
     */
    private int size;

    private static class Node {
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }
    }

    /**
     * 构造方法，初始化双端链表
     */
    public DoublePointLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    /**
     * 链表头部新增节点
     *
     * @param data
     */
    public void addHead(Object data) {
        Node node = new Node(data);
        // 如果链表为空，头尾都是该新增节点
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    /**
     * 链表尾部新增节点
     *
     * @param data
     */
    public void addTail(Object data) {
        Node node = new Node(data);
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    /**
     * 删除链表头节点
     *
     * @return 删除成功返回 true，失败返回 false
     */
    public boolean removeHead() {
        // 链表为空，删除失败
        if (size == 0) {
            return false;
        }
        if (head.next == null) { // 链表只有一个节点
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        size--;
        return true;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    /**
     * 显示链表详情
     */
    public void getAll() {
        if (size > 0) {
            Node node = head;
            int tempSize = size;
            if (tempSize == 1) {
                System.out.print("[" + node.data + "]");
                return;
            }
            while (tempSize > 0) {
                if (node.equals(head)) {
                    System.out.print("[" + node.data + "->");
                } else if (node.next == null) {
                    System.out.print(node.data + "]");
                } else {
                    System.out.print(node.data + "->");
                }
                node = node.next;
                tempSize--;
            }
            System.out.println();
        } else {
            System.out.println("[]");
        }
    }
}
