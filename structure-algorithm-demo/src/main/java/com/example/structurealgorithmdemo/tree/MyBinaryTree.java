package com.example.structurealgorithmdemo.tree;

/**
 * 二叉树实现
 *
 * @author Gary
 * @date 2019/12/10 17:32
 * @since jdk1.8
 **/
public class MyBinaryTree implements MyTree {

    private Node root;

    @Override
    public Node find(int data) {
        Node current = root;
        while (current != null) {
            if (current.data > data) {
                current = current.leftChild;
            } else if (current.data < data) {
                current = current.rightChild;
            } else {
                return current;
            }
        }
        return null;
    }

    @Override
    public boolean insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node current = root;
        Node parent;
        while (true) {
            parent = current;
            if (current.data > data) {
                current = current.leftChild;
                if (current == null) {
                    parent.leftChild = newNode;
                    return true;
                }
            } else {
                current = current.rightChild;
                if (current == null) {
                    parent.rightChild = newNode;
                    return true;
                }
            }
        }
    }

    @Override
    public void infixOrder(Node current) {
        if (current != null) {
            infixOrder(current.leftChild);
            System.out.print(current.data + " ");
            infixOrder(current.rightChild);
        }
    }

    @Override
    public void preOrder(Node current) {
        if (current != null) {
            System.out.print(current.data + " ");
            infixOrder(current.leftChild);
            infixOrder(current.rightChild);
        }
    }

    @Override
    public void postOrder(Node current) {
        if (current != null) {
            infixOrder(current.leftChild);
            infixOrder(current.rightChild);
            System.out.print(current.data + " ");
        }
    }

    @Override
    public Node findMax() {
        Node current = root;
        Node max = current;
        while (current != null) {
            max = current;
            current = current.rightChild;
        }
        return max;
    }

    @Override
    public Node findMin() {
        Node current = root;
        Node min = current;
        while (current != null) {
            min = current;
            current = current.leftChild;
        }
        return min;
    }

    @Override
    public boolean delete(int data) {
        return false;
    }
}
