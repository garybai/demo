package com.example.codedesigndemo.pattern.adapter;

/**
 * 对象适配器
 *
 * @author Gary
 * @date 2020/1/10 10:47
 * @since jdk1.8
 **/
public class ObjectAdapter implements Target {

    private Adaptee adaptee = new Adaptee();
    @Override
    public void method() {
        adaptee.adapteeMethod();
    }
}
