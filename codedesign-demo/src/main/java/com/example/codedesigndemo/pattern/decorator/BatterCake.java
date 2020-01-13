package com.example.codedesigndemo.pattern.decorator;

/**
 * 煎饼类
 *
 * @author Gary
 * @date 2020/1/10 15:34
 * @since jdk1.8
 **/
public class BatterCake implements Cake {
    @Override
    public String getName() {
        return "煎饼";
    }

    @Override
    public int cost() {
        return 5;
    }
}
