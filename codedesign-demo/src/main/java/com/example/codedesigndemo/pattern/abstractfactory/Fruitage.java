package com.example.codedesigndemo.pattern.abstractfactory;

/**
 * 具体植物-水果
 *
 * @author Gary
 * @date 2020/1/9 14:47
 * @since jdk1.8
 **/
public class Fruitage implements Plant {
    @Override
    public void show() {
        System.out.println("我是具体植物---水果");
    }
}
