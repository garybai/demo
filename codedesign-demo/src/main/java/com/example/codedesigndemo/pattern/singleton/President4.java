package com.example.codedesigndemo.pattern.singleton;

/**
 * 单例模式-静态内部类
 *
 * @author Gary
 * @date 2020/1/9 11:24
 * @since jdk1.8
 **/
public class President4 {

    /**
     * 构造方法私有
     */
    private President4() {
        System.out.println("初始化总统");
    }

    public static President4 getInstance(){
        return Inner.INSTANCE;
    }

    private static class Inner{
        private static final President4 INSTANCE = new President4();
    }

    public void getName(){
        System.out.println("我是特朗普");
    }
}
