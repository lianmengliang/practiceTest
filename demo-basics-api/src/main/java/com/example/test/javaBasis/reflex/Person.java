package com.example.test.javaBasis.reflex;

import io.swagger.annotations.Api;

/**
 * @Author ： Leo
 * @Date : 2021/6/18 15:12
 * @Desc:
 */
@Api
public class Person extends P implements A, B {

    /**
     * 属性
     */
    public String name;

    protected int age;

    String job;

    private double sal;


    /**
     * 方法
     */

    public void m1(String name, Integer b) {

    }

    protected void m2(int a) {

    }

    void m3(double b) {

    }

    private void m4() {

    }

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;

    }

    private Person(String name, int age, String job, double sal) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.sal = sal;
    }
}

class P {
    public String happy;

    public P() {
    }
}

interface A {

}

interface B {

}