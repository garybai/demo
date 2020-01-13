package com.example.codedesigndemo.pattern.builder;

/**
 * 具体建造者：具体装修工人2
 *
 * @author Gary
 * @date 2020/1/9 15:18
 * @since jdk1.8
 **/
public class ConcreteDecorator2 extends AbstractDecorator {
    @Override
    public void buildWall() {
        parlour.setWall("wall2");
    }

    @Override
    public void buildTv() {
        parlour.setTv("tv2");
    }

    @Override
    public void buildSofa() {
        parlour.setSofa("sofa2");
    }
}
