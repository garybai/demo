package com.example.codedesigndemo.pattern.iterator;

import lombok.AllArgsConstructor;

/**
 * 学生类
 *
 * @author Gary
 * @date 2020/1/11 18:29
 * @since jdk1.8
 **/
@AllArgsConstructor
public class Student {
    private String name;
    private Integer id;

    public void count() {
        System.out.println("我是" + id + "号学生：" + name);
    }
}
