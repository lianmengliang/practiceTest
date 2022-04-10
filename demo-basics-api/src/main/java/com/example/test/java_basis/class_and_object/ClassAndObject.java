package com.example.test.java_basis.class_and_object;

/**
 * lianmengliang
 * <p>
 * 2022-03-20 19:11
 */
public class ClassAndObject {

    public static void main(String[] args) {

        Cat cat = new Cat();
        System.out.println(cat.hashCode());


        System.out.println(cat);

    }
}

class Cat {
    private String name;
    private int age;
}