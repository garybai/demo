package com.example.structurealgorithmdemo.lru;

/**
 * 数组实现 LRU
 *
 * @author Gary
 * @date 2019/12/9 10:28
 * @since jdk1.8
 **/
public class LruByArray {

    private int totalLength = 5;
    private MyArray lruArray = new MyArray(totalLength);

    /**
     * 数组尾部为最新
     *
     * @param n
     */
    public void cache1(int n) {
        int i = lruArray.findReverse(n);
        // 未找到
        if (i == -1) {
            // 数组已满
            if (lruArray.getSize() == totalLength) {
                // 删除第一个元素，然后把新元素添加到尾部
                lruArray.deleteByIndex(0);
                lruArray.addTail(n);
            } else {
                // 数组未满，直接添加到尾部
                lruArray.addTail(n);
            }
        } else {
            // 找到则删除该元素，然后添加到数组尾部
            lruArray.deleteByIndex(i);
            lruArray.addTail(n);
        }
    }

    /**
     * 数组头部为最新
     *
     * @param n
     */
    public void cache2(int n) {
        int i = lruArray.find(n);
        if (i == -1) {
            if (lruArray.getSize() == totalLength) {
                lruArray.deleteByIndex(totalLength - 1);
                lruArray.addHead(n);
            } else {
                lruArray.addHead(n);
            }
        } else {
            lruArray.deleteByIndex(i);
            lruArray.addHead(n);
        }
    }

    public void display() {
        lruArray.display();
    }
}
