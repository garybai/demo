package com.example.structurealgorithmdemo.linkedlist;

/**
 * @author Gary
 * @className SingleLinkedList
 * @description TODO
 * @date 2019/11/16 23:32
 **/
public class SingleLinkedList {

    // 链表长度
    private int size;
    // 链表头节点
    private Node head;

    // 构造方法
    public SingleLinkedList() {
        size = 0;
        head = null;
    }

    // 链表的每个节点
    private class Node {
        private Object data; // 存储数据
        private Node next; // 指向下一个节点

        public Node(Object data) {
            this.data = data;
        }
    }

    // 在链表头部添加
    public void addHead(Object object) {
        Node newHead = new Node(object);
        if (size == 0) {
            head = newHead;
        } else {
            newHead.next = head;
            head = newHead;
        }
        size++;
    }

    // 删除链表头
    public void removeHead() {
        head = head.next;
        size--;
    }

    // 查找指定元素
    public Node find(Object object) {
        Node temp = head;
        int tempSize = size;
        while (tempSize > 0) {
            if (temp.data.equals(object)) {
                return temp;
            } else {
                temp = temp.next;
            }
            tempSize--;
        }
        return null;
    }

    // 删除指定元素
    public boolean remove(Object object) {
        if (size == 0) {
            return false;
        }
        Node temp = head;
        Node prev = head;
        while (temp.data != object) {
            if (temp.next == null) {
                return false;
            } else {
                prev = temp;
                temp = temp.next;
            }
        }
        // 如果删除的是第一个节点
        if (temp == head) {
            head = head.next;
            size--;
        } else {
            prev.next = temp.next;
            size--;
        }
        return true;
    }

    // 判断链表是否为空
    public boolean isEmpty() {
        return (size == 0);
    }

    // 显示链表详情
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
