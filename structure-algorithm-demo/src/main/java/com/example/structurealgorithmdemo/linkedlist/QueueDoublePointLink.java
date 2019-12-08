package com.example.structurealgorithmdemo.linkedlist;

/**
 * 双端链表实现队列
 *
 * @author Gary
 * @date 2019/12/8 18:08
 * @since jdk1.8
 **/
public class QueueDoublePointLink {

    private DoublePointLinkedList dp;

    public QueueDoublePointLink(){
        dp = new DoublePointLinkedList();
    }

    public void insert(Object data){
        dp.addTail(data);
    }

    public void delete(){
        dp.removeHead();
    }

    public boolean isEmpty(){
        return dp.isEmpty();
    }

    public int getSize(){
        return dp.getSize();
    }

    public void display(){
        dp.getAll();
    }
}
