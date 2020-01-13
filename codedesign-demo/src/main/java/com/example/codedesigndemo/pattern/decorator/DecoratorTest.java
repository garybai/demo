package com.example.codedesigndemo.pattern.decorator;

/**
 * 装饰者模式测试
 *
 * @author Gary
 * @date 2020/1/10 15:40
 * @since jdk1.8
 **/
public class DecoratorTest {

    public static void main(String[] args) {
        Cake cake = new BatterCake();
        System.out.println(cake.getName() + "---" + cake.cost());
        cake = new EggDecorator(cake);
        System.out.println(cake.getName() + "---" + cake.cost());
        cake = new SausageDecorator(cake);
        System.out.println(cake.getName() + "---" + cake.cost());
    }
}
