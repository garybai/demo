package com.example.codedesigndemo.pattern.bridge;

/**
 * 钱包
 *
 * @author Gary
 * @date 2020/1/10 15:07
 * @since jdk1.8
 **/
public class Wallet extends AbstractBag {
    @Override
    public String getName() {
        return color.getColor() + "钱包";
    }
}
