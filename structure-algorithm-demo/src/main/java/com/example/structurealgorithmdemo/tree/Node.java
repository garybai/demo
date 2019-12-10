package com.example.structurealgorithmdemo.tree;

/**
 * tree 的节点
 *
 * @author Gary
 * @date 2019/12/10 17:27
 * @since jdk1.8
 **/
public class Node {
    int data;
    Node leftChild;
    Node rightChild;
    boolean isDelete;

    public Node(int data){
        this.data = data;
    }

    public void display(){
        System.out.println(data);
    }
}
