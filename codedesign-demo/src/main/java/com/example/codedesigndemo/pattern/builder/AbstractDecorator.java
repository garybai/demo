package com.example.codedesigndemo.pattern.builder;

/**
 * 抽象建造者：装修工人
 *
 * @author Gary
 * @date 2020/1/9 15:14
 * @since jdk1.8
 **/
abstract class AbstractDecorator {

    Parlour parlour = new Parlour();
    public abstract void buildWall();
    public abstract void buildTv();
    public abstract void buildSofa();

    public Parlour getParlour(){
        return parlour;
    }
}
