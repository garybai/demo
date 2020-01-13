package com.example.codedesigndemo.pattern.proxy;

/**
 * 真实主题
 *
 * @author Gary
 * @date 2020/1/9 16:28
 * @since jdk1.8
 **/
public class WySpecialty implements Specialty {
    @Override
    public void display() {
        System.out.println("婺源特产");
    }
}
