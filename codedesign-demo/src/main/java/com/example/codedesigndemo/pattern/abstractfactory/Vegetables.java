package com.example.codedesigndemo.pattern.abstractfactory;

/**
 * 具体植物-蔬菜
 *
 * @author Gary
 * @date 2020/1/9 14:48
 * @since jdk1.8
 **/
public class Vegetables implements Plant {
    @Override
    public void show() {
        System.out.println("我是具体植物---蔬菜");
    }
}
