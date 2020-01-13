package com.example.codedesigndemo.pattern.singleton;

/**
 * 单例模式-枚举方式
 *
 * @author Gary
 */
public enum President5 {

    /**
     * 实例
     */
    INSTENCE;

    President5(){
        System.out.println("初始化总统");
    }

    public void getName(){
        System.out.println("我是特朗普");
    }

    /**
     * 可以省略此方法，President5.INSTANCE进行操作
     * @return
     */
    public static President5 getInstance(){
        return President5.INSTENCE;
    }
}
