package com.example.codedesigndemo.pattern.factorymethod;

/**
 * 具体商品-空调
 *
 * @author Gary
 * @date 2020/1/9 14:18
 * @since jdk1.8
 **/
public class AirConditioner implements Product {
    @Override
    public void show() {
        System.out.println("我是空调");
    }
}
