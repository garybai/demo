package com.example.codedesigndemo.pattern.decorator;

/**
 * 抽象装饰类
 *
 * @author Gary
 * @date 2020/1/10 15:35
 * @since jdk1.8
 **/
public class AbstractDecorator implements Cake {

    private Cake cake;

    public AbstractDecorator(Cake cake){
        this.cake = cake;
    }

    @Override
    public String getName() {
        return this.cake.getName();
    }

    @Override
    public int cost() {
        return this.cake.cost();
    }
}
