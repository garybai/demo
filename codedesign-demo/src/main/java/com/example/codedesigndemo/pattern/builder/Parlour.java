package com.example.codedesigndemo.pattern.builder;

/**
 * 产品：客厅
 *
 * @author Gary
 * @date 2020/1/9 15:11
 * @since jdk1.8
 **/
public class Parlour {
    private String wall;
    private String tv;
    private String sofa;

    public void show() {
        System.out.println(wall + " " + tv + " " + sofa);
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public void setSofa(String sofa) {
        this.sofa = sofa;
    }

}
