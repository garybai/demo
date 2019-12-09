package com.example.structurealgorithmdemo.lru;

/**
 * @author Gary
 * @className SingleLinkedList
 * @description TODO
 * @date 2019/11/16 23:32
 **/
public class SingleLinkedList {

    // 链表总长度
    private int totalLength;
    // 链表有效长度
    private int size;
    // 链表头节点
    private Node head;

    // 构造方法
    public SingleLinkedList(int totalLength) {
        this.size = 0;
        this.head = null;
        this.totalLength = totalLength;
    }

    // 链表的每个节点
    static class Node {
        private Object data; // 存储数据
        private Node next; // 指向下一个节点

        public Node(Object data) {
            this.data = data;
        }
        public Object getData(){
            return data;
        }
    }

    // 在链表头部添加
    public void addHead(Object object) {
        if (size == totalLength){
            return;
        }
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
    public Object removeHead() {
        Object o = head.data;
        head = head.next;
        size--;
        return o;
    }

    // 删除链表尾
    public Object removeTail(){
        Node temp = head;
        Node prev = null;
        while (temp.next != null){
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        size--;
        return prev;
    }

    // 查找指定元素
    public Node find(Object object) {
        // 从头节点开始遍历
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
        // 存储上一个节点，因为删除后需要将上一个节点的指针指向下一个节点
        Node prev = head;
        while (temp.data != object) {
            // 循环到尾节点如果未找到指定元素
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

    public int getSize(){
        return size;
    }

    // 显示链表详情
    public void display() {
        if (size > 0) {
            Node node = head;
            int tempSize = size;
            if (tempSize == 1) {
                System.out.println("[" + node.data + "]");
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
