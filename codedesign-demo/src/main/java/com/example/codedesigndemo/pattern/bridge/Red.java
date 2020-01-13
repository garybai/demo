package com.example.codedesigndemo.pattern.bridge;

/**
 * 红色
 *
 * @author Gary
 * @date 2020/1/10 15:03
 * @since jdk1.8
 **/
public class Red implements Color {
    @Override
    public String getColor() {
        return "红色";
    }
}
