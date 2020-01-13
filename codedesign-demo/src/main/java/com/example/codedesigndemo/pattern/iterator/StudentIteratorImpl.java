package com.example.codedesigndemo.pattern.iterator;

import java.util.List;

/**
 * 学生迭代器实现类
 *
 * @author Gary
 * @date 2020/1/11 18:34
 * @since jdk1.8
 **/
public class StudentIteratorImpl implements StudentIterator {
    private List<Student> students;
    private int position = 0;
    private Student curr;

    public StudentIteratorImpl(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean hasNext() {
        return position < students.size();
    }

    @Override
    public Student next() {
        curr = students.get(position);
        position++;
        return curr;
    }
}
