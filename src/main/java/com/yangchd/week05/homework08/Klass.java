package com.yangchd.week05.homework08;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private int id;
    private String name;

    public Klass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public String toString() {
        return "MyClass::" + students.toString();
    }
}
