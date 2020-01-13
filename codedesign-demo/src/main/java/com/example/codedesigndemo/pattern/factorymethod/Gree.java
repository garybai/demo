package com.example.codedesigndemo.pattern.factorymethod;

/**
 * 具体工厂Gree
 *
 * @author Gary
 * @date 2020/1/9 14:23
 * @since jdk1.8
 **/
public class Gree implements Factory {
    @Override
    public Product newProduct() {
        System.out.println("我是格力，我生产空调");
        return new AirConditioner();
    }
}
