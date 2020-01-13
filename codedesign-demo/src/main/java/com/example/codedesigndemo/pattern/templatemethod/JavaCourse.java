package com.example.codedesigndemo.pattern.templatemethod;

/**
 * Java课程
 *
 * @author Gary
 * @date 2020/1/11 15:18
 * @since jdk1.8
 **/
public class JavaCourse extends Acourse {
    @Override
    public void packageCourse() {
        System.out.println("4. 提供Java课程源代码");
    }

    @Override
    public boolean needWriteArticle() {
        return true;
    }
}
