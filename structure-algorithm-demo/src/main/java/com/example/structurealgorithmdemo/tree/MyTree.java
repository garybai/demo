package com.example.structurealgorithmdemo.tree;

/**
 * @author Gary
 */
public interface MyTree {
    Node find(int key);
    boolean insert(int data);
    void infixOrder(Node current);
    void preOrder(Node current);
    void postOrder(Node current);
    Node findMax();
    Node findMin();
    boolean delete(int data);
}
