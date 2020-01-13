package com.example.codedesigndemo.pattern.abstractfactory;

/**
 * 具体动物-牛
 *
 * @author Gary
 * @date 2020/1/9 14:46
 * @since jdk1.8
 **/
public class Cattle implements Animal {
    @Override
    public void show() {
        System.out.println("我是具体动物---牛");
    }
}
