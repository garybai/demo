package com.example.codedesigndemo.pattern.builder;

/**
 * 建造者模式测试
 *
 * @author Gary
 * @date 2020/1/9 15:22
 * @since jdk1.8
 **/
public class BuilderTest {

    public static void main(String[] args) {
        AbstractDecorator decorator = new ConcreteDecorator2();
        ProjectManager manager = new ProjectManager(decorator);
        Parlour parlour = manager.build();
        parlour.show();
    }
}
