package com.example.codedesigndemo.pattern.adapter;

/**
 * 类适配器
 *
 * @author Gary
 * @date 2020/1/10 10:33
 * @since jdk1.8
 **/
public class ClassAdapter extends Adaptee implements Target {
    @Override
    public void method() {
        super.adapteeMethod();
    }
}
