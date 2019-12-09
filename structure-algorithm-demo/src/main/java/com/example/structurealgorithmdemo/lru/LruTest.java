package com.example.structurealgorithmdemo.lru;

/**
 * 数组实现 lru 测试
 *
 * @author Gary
 * @date 2019/12/9 11:23
 * @since jdk1.8
 **/
public class LruTest {

    public static void main(String[] args) {
        LruByArray lru = new LruByArray();
        lru.cache1(1);
        lru.display();
        lru.cache1(3);
        lru.display();
        lru.cache1(2);
        lru.display();
        lru.cache1(4);
        lru.display();
        lru.cache1(3);
        lru.display();
        lru.cache1(2);
        lru.display();
        lru.cache1(5);
        lru.display();
        lru.cache1(6);
        lru.display();

        LruByArray lru1 = new LruByArray();
        lru1.cache2(1);
        lru1.display();
        lru1.cache2(3);
        lru1.display();
        lru1.cache2(2);
        lru1.display();
        lru1.cache2(4);
        lru1.display();
        lru1.cache2(3);
        lru1.display();
        lru1.cache2(2);
        lru1.display();
        lru1.cache2(5);
        lru1.display();
        lru1.cache2(6);
        lru1.display();

        LruBySingleLinkedList lru2 = new LruBySingleLinkedList();
        lru2.cache(1);
        lru2.display();
        lru2.cache(3);
        lru2.display();
        lru2.cache(2);
        lru2.display();
        lru2.cache(4);
        lru2.display();
        lru2.cache(3);
        lru2.display();
        lru2.cache(2);
        lru2.display();
        lru2.cache(5);
        lru2.display();
        lru2.cache(6);
        lru2.display();
    }
}
