package com.example.structurealgorithmdemo.array;

/**
 * MyArray 测试
 *
 * @author Gary
 * @date 2019/12/7 22:51
 * @since jdk1.8
 **/
public class MyArrayTest {

    public static void main(String[] args) {
        MyArray array = new MyArray(4);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        System.out.println(array.getSize());
        array.display();
        System.out.println();
        System.out.println(array.get(2));
        array.delete(2);
        array.display();
        System.out.println();
        array.modify(1, 11);
        array.display();
    }
}
