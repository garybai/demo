package com.example.structurealgorithmdemo.lru;

/**
 * 单向链表实现 lru
 *
 * @author Gary
 * @date 2019/12/9 14:00
 * @since jdk1.8
 **/
public class LruBySingleLinkedList {

    /**
     * 链表可用总长度
     */
    private int totalLength = 5;

    private SingleLinkedList linkedList = new SingleLinkedList(totalLength);

    /**
     * 链表头部为最新
     * @param value
     */
    public void cache(int value){
        SingleLinkedList.Node node = linkedList.find(value);
        // 元素在当前链表中不存在
        if (node == null){
            // 如果链表已满，删除尾部元素，将新元素插入到头部
            if (linkedList.getSize() == totalLength){
                linkedList.removeTail();
                linkedList.addHead(value);
            }else {
                // 如果链表未满，直接插入到头部
                linkedList.addHead(value);
            }
        } else {
            // 链表中找到该元素，然后删除，然后在插入到头部
            linkedList.remove(value);
            linkedList.addHead(value);
        }
    }

    public void display(){
        linkedList.display();
    }
}
