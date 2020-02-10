package com.example.springaopdemo.util;

/**
 * aop日志
 *
 * @author Gary
 * @date 2020/1/29 11:04
 * @since jdk1.8
 **/
public class Logger {
    /**
     * 用于打印日志：计划让其在切入点方法执行之前执行（切入点方法就是业务层方法）
     */
    public void printLog() {
        System.out.println("Logger类中的pringLog方法开始记录日志了。。。");
    }
}
