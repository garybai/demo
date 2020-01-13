package com.example.codedesigndemo.pattern.singleton;

/**
 * 单例模式-双重锁模式
 *
 * @author Gary
 * @date 2020/1/9 11:20
 * @since jdk1.8
 **/
public class President3 {

    /**
     * 构造方法私有
     */
    private President3() {
        System.out.println("初始化总统");
    }

    /**
     * 自己类型的属性
     * volatile 禁止指令重排序
     */
    private volatile static President3 instance;

    /**
     * 对外提供获取实例的方法
     *
     * @return
     */
    public static President3 getInstance() {
        // 线程安全，双重锁校验
        if (instance == null) {
            // 加锁保证只有一个线程可创建实例
            synchronized (President3.class) {
                if (instance == null) {
                    instance = new President3();
                    System.out.println("总统初始化成功");
                }
            }
        } else {
            System.out.println("已经有一个总统");
        }
        return instance;
    }

    public void getName(){
        System.out.println("我是特朗普");
    }
}
