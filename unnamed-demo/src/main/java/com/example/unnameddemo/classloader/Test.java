package com.example.unnameddemo.classloader;

/**
 * 测试类
 *
 * @author Gary
 * @date 2020/3/20 11:54
 * @since jdk1.8
 **/
public class Test {

    public Test(){
        System.out.println(this.getClass().getClassLoader().toString());
    }
}
