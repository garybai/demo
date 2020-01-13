package com.example.codedesigndemo.pattern.factorymethod;

/**
 * 工厂方法模式测试
 *
 * @author Gary
 * @date 2020/1/9 14:26
 * @since jdk1.8
 **/
public class FactoryMethodTest {
    public static void main(String[] args) {

        Factory factory1 = new Gree();
        Product product1 = factory1.newProduct();
        product1.show();

        Factory factory2 = new Midea();
        Product product2 = factory2.newProduct();
        product2.show();
    }
}
