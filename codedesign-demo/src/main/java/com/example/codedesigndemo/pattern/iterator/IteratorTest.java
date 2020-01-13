package com.example.codedesigndemo.pattern.iterator;

/**
 * 迭代器模式测试
 *
 * @author Gary
 * @date 2020/1/11 18:38
 * @since jdk1.8
 **/
public class IteratorTest {

    public static void main(String[] args) {
        StudentAggregate class1 = new StudentAggregateImpl();
        class1.addStudent(new Student("张三", 1));
        class1.addStudent(new Student("李四", 2));
        class1.addStudent(new Student("王五", 3));
        class1.addStudent(new Student("赵六", 4));

        StudentIterator iterator = class1.getStudentIterator();
        while (iterator.hasNext()){
            iterator.next().count();
        }
    }
}
