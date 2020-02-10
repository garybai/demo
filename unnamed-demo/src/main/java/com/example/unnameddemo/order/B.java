package com.example.unnameddemo.order;

/**
 * 子类B
 *
 * @author Gary
 * @date 2020/2/6 14:50
 * @since jdk1.8
 **/
public class B extends A {

    public B(){
        System.out.println("B Constructor");
        System.out.println("B test");
    }

    static {
        System.out.println("B Static");
    }

    {
        System.out.println("B null");
    }

    @Override
    public String test() {
        return "B test";
    }
}

class Test{
    public static void main(String[] args) {
        B b = new B();
    }
}
