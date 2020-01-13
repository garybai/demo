package com.example.codedesigndemo.pattern.singleton;

/**
 * 单例模式-懒汉式
 *
 * @author Gary
 * @date 2020/1/9 11:08
 * @since jdk1.8
 **/
public class President1 {

    /**
     * 构造方法私有
     */
    private President1() {
        System.out.println("初始化总统");
    }

    /**
     * 自己类型的属性
     */
    private static President1 instance;

    /**
     * 对外提供获取实例的方法
     * @return
     */
    public static President1 getInstance() {
        // 存在线程不安全问题
        if (instance == null) {
            instance = new President1();
            System.out.println("总统初始化成功");
        } else {
            System.out.println("已经有一个总统");
        }
        return instance;
    }

    public void getName(){
        System.out.println("我是特朗普");
    }
}
