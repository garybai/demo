package com.example.codedesigndemo.pattern.bridge;

/**
 * 桥接模式测试
 *
 * @author Gary
 * @date 2020/1/10 15:09
 * @since jdk1.8
 **/
public class BridgeTest {

    public static void main(String[] args) {
        AbstractBag bag1 = new HandBag();
        bag1.setColor(new Red());
        System.out.println(bag1.getName());

        AbstractBag bag2 = new Wallet();
        bag2.setColor(new Yellow());
        System.out.println(bag2.getName());
    }
}
