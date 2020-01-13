package com.example.codedesigndemo.pattern.prototype;

/**
 * 原型模式测试
 *
 * @author Gary
 * @date 2020/1/9 16:10
 * @since jdk1.8
 **/
public class PrototypeTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Citation citation = new Citation("张三","同学：在2016学年第一学期中表现优秀，被评为三好学生。","韶关学院");
        citation.display();
        Citation citation1 = citation.clone();
        citation1.setName("李四");
        citation1.display();
    }
}
