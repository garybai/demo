package com.example.codedesigndemo.pattern.prototype;

/**
 * 奖状类
 *
 * @author Gary
 * @date 2020/1/9 16:05
 * @since jdk1.8
 **/
public class Citation implements Cloneable {
    String name;
    String info;
    String college;

    Citation(String name, String info, String college) {
        this.name = name;
        this.info = info;
        this.college = college;
        System.out.println("奖状创建成功");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println(name + info + college);
    }

    @Override
    public Citation clone() throws CloneNotSupportedException {
        System.out.println("奖状克隆成功");
        return (Citation) super.clone();
    }
}
