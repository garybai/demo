package com.example.structurealgorithmdemo.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 基于数组的栈
 *
 * @author Gary
 * @date 2019/12/9 15:12
 * @since jdk1.8
 **/
public class MyArrayStack {

    /**
     * 默认初始容量
     */
    private final static int DEFAULT_CAPACITY = 10;

    /**
     * 存放数据的数组，类型为 object
     */
    private Object[] elementData;
    /**
     * 指向栈顶的指针
     */
    private int top;
    /**
     * 栈的总容量
     */
    private int size;

    public MyArrayStack() {
        this.elementData = new Object[DEFAULT_CAPACITY];
        this.top = -1;
        this.size = DEFAULT_CAPACITY;
    }

    public MyArrayStack(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("栈初始容量不能小于0：" + initialCapacity);
        }
        this.elementData = new Object[initialCapacity];
        this.top = -1;
        this.size = initialCapacity;
    }

    /**
     * 压入元素
     *
     * @param object
     * @return
     */
    public Object push(Object object) {
        // 判断是否需要扩容
        // top+1 表示当前元素个数，top+1+1 表示压入目前这个元素之后的元素个数
        isGrow(top + 1 + 1);
        elementData[++top] = object;
        return object;
    }

    /**
     * 弹出元素
     *
     * @return
     */
    public Object pop() {
        Object peek = peek();
        remove();
        return peek;
    }

    /**
     * 获取栈顶元素
     *
     * @return
     */
    public Object peek() {
        if (top == -1) {
            throw new EmptyStackException();
        }
        return elementData[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 删除栈顶元素
     */
    public void remove() {
        elementData[top] = null;
        this.top--;
    }

    /**
     * 判断是否需要扩容
     *
     * @param minCapacity
     * @return
     */
    public boolean isGrow(int minCapacity) {
        int oldCapacity = size;
        // 如果当前元素压入栈以后所需容量大于总容量，则需要扩容
        if (minCapacity > oldCapacity) {
            int newCapaticy;
            if ((oldCapacity << 1) - Integer.MAX_VALUE > 0) {
                newCapaticy = Integer.MAX_VALUE;
            } else {
                // 左移 1 位，相当于乘以 2
                newCapaticy = (oldCapacity << 1);
            }
            this.size = newCapaticy;
            elementData = Arrays.copyOf(elementData, size);
            return true;
        } else {
            return false;
        }
    }

}
