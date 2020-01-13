package com.example.codedesigndemo.pattern.factorymethod;

/**
 * 具体工厂Midea
 *
 * @author Gary
 * @date 2020/1/9 14:25
 * @since jdk1.8
 **/
public class Midea implements Factory {
    @Override
    public Product newProduct() {
        System.out.println("我是美的，我生产电饭煲");
        return new ElectricCooker();
    }
}
