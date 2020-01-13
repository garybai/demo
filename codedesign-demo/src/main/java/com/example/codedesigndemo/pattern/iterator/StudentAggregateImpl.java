package com.example.codedesigndemo.pattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 班级实现类
 *
 * @author Gary
 * @date 2020/1/11 18:32
 * @since jdk1.8
 **/
public class StudentAggregateImpl implements StudentAggregate {

    private List<Student> students;

    public StudentAggregateImpl(){
        this.students = new ArrayList<>();
    }

    @Override
    public void addStudent(Student student) {
        this.students.add(student);
    }

    @Override
    public void removeStudent(Student student) {
        this.students.remove(student);
    }

    @Override
    public StudentIterator getStudentIterator() {
        return new StudentIteratorImpl(students);
    }
}
