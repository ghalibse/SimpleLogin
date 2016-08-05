package com.example.simplelogin;

/**
 * Created by admin on 8/5/2016.
 */
public class Student {

    String name;
    int age;
    double grade;
    String password;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                ", passWord='" + password + '\'' +
                '}';
    }
}
