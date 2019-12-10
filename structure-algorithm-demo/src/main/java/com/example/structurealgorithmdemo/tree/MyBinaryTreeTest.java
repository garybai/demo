package com.example.structurealgorithmdemo.tree;

/**
 * 二叉树测试
 *
 * @author Gary
 * @date 2019/12/10 18:36
 * @since jdk1.8
 **/
public class MyBinaryTreeTest {
    public static void main(String[] args) {
        MyBinaryTree binaryTree = new MyBinaryTree();
        binaryTree.insert(50);
        binaryTree.insert(75);
        binaryTree.insert(8);
        binaryTree.insert(6);
        binaryTree.insert(13);
        binaryTree.insert(49);
        binaryTree.insert(49);
        binaryTree.insert(100);
        System.out.println(binaryTree.findMax().data);

        Node node = binaryTree.find(50);
        binaryTree.infixOrder(node);
        System.out.println();

        binaryTree.preOrder(node);
        System.out.println();

        binaryTree.postOrder(node);
        System.out.println();
    }
}
