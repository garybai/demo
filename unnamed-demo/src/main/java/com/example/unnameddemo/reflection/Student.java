package com.example.unnameddemo.reflection;

import lombok.Data;

/**
 * 学生类
 *
 * @author Gary
 * @date 2019/12/25 14:53
 * @since jdk1.8
 **/
@Data
public class Student {

    private String name;
    private Integer age;

    public void doHomework(String subject){
        System.out.println("我是" + name + "，我" + age + "岁了，我在做" + subject + "作业");
    }

}
