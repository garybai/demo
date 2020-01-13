package com.example.codedesigndemo.pattern.decorator;

/**
 * 香肠装饰器
 *
 * @author Gary
 * @date 2020/1/10 15:44
 * @since jdk1.8
 **/
public class SausageDecorator extends AbstractDecorator {
    public SausageDecorator(Cake cake) {
        super(cake);
    }

    @Override
    public String getName() {
        return super.getName() + "加一根香肠";
    }

    @Override
    public int cost() {
        return super.cost() + 2;
    }
}
