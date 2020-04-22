package com.example.practice.model;

import lombok.Data;

/**
 * @Author ： leo
 * @Date :2020/4/22 12:16
 */
@Data
public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
}
