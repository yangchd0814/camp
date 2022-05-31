package com.yangchd.week05.homework08;

import java.util.List;

public class School {
    private List<Klass> myClasses;

    public School(List<Klass> myClasses) {
        this.myClasses = myClasses;
    }

    @Override
    public String toString() {
        return "MyClass::" + myClasses.toString();
    }
}
