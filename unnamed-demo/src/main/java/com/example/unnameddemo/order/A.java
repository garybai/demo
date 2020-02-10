package com.example.unnameddemo.order;

/**
 * 父类A
 *
 * @author Gary
 * @date 2020/2/6 14:49
 * @since jdk1.8
 **/
public class A {

    public A() {
        System.out.println("A Constructor");
        System.out.println(test());
    }

    static {
        System.out.println("A Static");
    }
    {
        System.out.println("A null");
    }

    public String test(){
        return "A test";
    }
}
