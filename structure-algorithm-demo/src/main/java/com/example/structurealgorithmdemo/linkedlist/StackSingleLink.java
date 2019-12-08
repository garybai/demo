package com.example.structurealgorithmdemo.linkedlist;

/**
 * 单向链表实现栈
 *
 * @author Gary
 * @date 2019/12/8 13:10
 * @since jdk1.8
 **/
public class StackSingleLink {

    private SingleLinkedList linkedList;

    /**
     * 内部初始化一个单向链表
     */
    public StackSingleLink() {
        linkedList = new SingleLinkedList();
    }

    /**
     * 添加元素
     * @param o
     */
    public void push(Object o){
        linkedList.addHead(o);
    }

    /**
     * 移除栈顶元素
     * @return
     */
    public Object pop(){
        return linkedList.removeHead();
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        return linkedList.isEmpty();
    }

    /**
     * 打印栈内元素信息
     */
    public void display(){
        linkedList.getAll();
    }
}
