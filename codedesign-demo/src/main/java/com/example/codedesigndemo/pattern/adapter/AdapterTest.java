package com.example.codedesigndemo.pattern.adapter;

/**
 * 适配器模式测试
 *
 * @author Gary
 * @date 2020/1/10 10:45
 * @since jdk1.8
 **/
public class AdapterTest {
    public static void main(String[] args) {
        Target target = new ClassAdapter();
        target.method();
        Target target1 = new ObjectAdapter();
        target1.method();
    }
}
