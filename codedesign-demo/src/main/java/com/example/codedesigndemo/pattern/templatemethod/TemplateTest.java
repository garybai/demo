package com.example.codedesigndemo.pattern.templatemethod;

/**
 * 模板方法模式测试
 *
 * @author Gary
 * @date 2020/1/11 15:22
 * @since jdk1.8
 **/
public class TemplateTest {

    public static void main(String[] args) {
        Acourse javaCourse = new JavaCourse();
        javaCourse.makeCourse();

        Acourse pythonCourse = new PythonCourse(false);
        pythonCourse.makeCourse();
    }
}
