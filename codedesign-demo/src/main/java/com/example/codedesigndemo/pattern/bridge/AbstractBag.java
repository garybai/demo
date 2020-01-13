package com.example.codedesigndemo.pattern.bridge;

/**
 * 抽象包类
 *
 * @author Gary
 * @date 2020/1/10 15:04
 * @since jdk1.8
 **/
abstract class AbstractBag {
    protected Color color;
    public void setColor(Color color){
        this.color = color;
    }
    public abstract String getName();
}
