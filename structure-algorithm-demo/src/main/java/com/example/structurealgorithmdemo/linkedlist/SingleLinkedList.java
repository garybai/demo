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
    public static class Node {
        private Object data; // 存储数据
        private Node next; // 指向下一个节点

        public Node(Object data) {
            this.data = data;
        }
        public Object getValue() {
            return data;
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
    public Object removeHead() {
        Object o = head.data;
        head = head.next;
        size--;
        return o;
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

    /**
     * 链表逆序
     */
    public void reverse() {
        if (head == null || head.next == null) {
            return;
        }
        Node p = head;
        Node q = head.next;
        p.next = null;
        Node tmp;
        while (q != null) {
            tmp = q.next;
            q.next = p;
            p = q;
            q = tmp;
        }
        head = p;
    }

    public Node reverse1() {
        if (head == null || head.next == null) {
            return null;
        }
//        Node newHead = null;
//        while (head.next != null){
//            Node next = head.next;
//            head.next = newHead;
//            newHead = head;
//            head = next;
//        }
//        return newHead;

        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;

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
