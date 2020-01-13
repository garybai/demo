package com.example.codedesigndemo.pattern.decorator;

/**
 * 鸡蛋装饰器
 *
 * @author Gary
 * @date 2020/1/10 15:37
 * @since jdk1.8
 **/
public class EggDecorator extends AbstractDecorator {
    public EggDecorator(Cake cake) {
        super(cake);
    }

    @Override
    public String getName() {
        return super.getName() + "加一个鸡蛋";
    }

    @Override
    public int cost() {
        return super.cost() + 1;
    }

    public void egg(){
        System.out.println("加蛋");
    }
}
