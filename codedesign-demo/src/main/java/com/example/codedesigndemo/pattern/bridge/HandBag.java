package com.example.codedesigndemo.pattern.bridge;

/**
 * 手提包
 *
 * @author Gary
 * @date 2020/1/10 15:06
 * @since jdk1.8
 **/
public class HandBag extends AbstractBag {
    @Override
    public String getName() {
        return color.getColor() + "手提包";
    }
}
