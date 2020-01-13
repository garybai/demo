package com.example.codedesigndemo.pattern.iterator;

public interface StudentAggregate {
    void addStudent(Student student);
    void removeStudent(Student student);
    StudentIterator getStudentIterator();
}
