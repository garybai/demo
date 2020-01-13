package com.example.codedesigndemo.pattern.builder;

/**
 * 指挥者：项目经理
 *
 * @author Gary
 * @date 2020/1/9 15:20
 * @since jdk1.8
 **/
public class ProjectManager {
    private AbstractDecorator builder;
    public ProjectManager(AbstractDecorator builder){
        this.builder = builder;
    }
    public Parlour build(){
        builder.buildWall();
        builder.buildTv();
        builder.buildSofa();
        return builder.getParlour();
    }
}
