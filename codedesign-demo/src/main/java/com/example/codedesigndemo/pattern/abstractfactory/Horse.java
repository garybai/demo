package com.example.codedesigndemo.pattern.abstractfactory;

/**
 * 具体动物-马
 *
 * @author Gary
 * @date 2020/1/9 14:45
 * @since jdk1.8
 **/
public class Horse implements Animal {
    @Override
    public void show() {
        System.out.println("我是具体的动物---马");
    }
}
