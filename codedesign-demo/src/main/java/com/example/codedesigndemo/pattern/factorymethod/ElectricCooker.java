package com.example.codedesigndemo.pattern.factorymethod;

/**
 * 具体商品-电饭煲
 *
 * @author Gary
 * @date 2020/1/9 14:20
 * @since jdk1.8
 **/
public class ElectricCooker implements Product {
    @Override
    public void show() {
        System.out.println("我是电饭煲");
    }
}
