package com.example.codedesigndemo.pattern.singleton;

/**
 * 单例模式-饿汉式
 *
 * @author Gary
 * @date 2020/1/9 11:18
 * @since jdk1.8
 **/
public class President2 {

    /**
     * 构造方法私有
     */
    private President2() {
        System.out.println("初始化总统");
    }

    /**
     * 自己类型的属性
     */
    private static President2 instance = new President2();

    /**
     * 对外提供获取实例的方法
     * @return
     */
    public static President2 getInstance() {
        // 线程安全，但容易产生垃圾
        return instance;
    }

    public void getName(){
        System.out.println("我是特朗普");
    }
}
