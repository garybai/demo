package com.example.structurealgorithmdemo.linkedlist;

/**
 * @author Gary
 * @className TestSingleLinkedList
 * @description TODO
 * @date 2019/11/17 0:13
 **/
public class SingleLinkedListTest {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.getAll();

        singleLinkedList.addHead("A");
        singleLinkedList.addHead("B");
        singleLinkedList.addHead("C");
        singleLinkedList.addHead("D");
        singleLinkedList.addHead("E");
        singleLinkedList.getAll();
        singleLinkedList.reverse();
        singleLinkedList.getAll();

        singleLinkedList.remove("C");
        singleLinkedList.getAll();

        singleLinkedList.removeHead();
        singleLinkedList.getAll();

        System.out.println(singleLinkedList.find("B"));
    }
}
