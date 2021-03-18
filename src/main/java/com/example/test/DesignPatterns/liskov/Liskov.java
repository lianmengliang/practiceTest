package com.example.test.DesignPatterns.liskov;

/**
 * @Author ： Leo
 * @Date : 2021/3/17 11:54
 * @Desc: 里氏代换原则
 * 1)继承包含这样一层含义：父类中凡是已经实现好的方法，实际上是在设定规范和契约，虽然它不强制要求所有的子类必须遵循这些契约，但是如果子类对这些已经实现的方法任意修改，就会对整个继承体系造成破坏。
 * 2)继承在给程序设计带来便利的同时，也带来了弊端。比如使用继承会给程序带来侵入性，程序的可移植性降低， 增加对象间的耦合性，如果一个类被其他的类所继承，则当这个类需要修改时，必须考虑到所有的子类，并且父类修改后，所有涉及到子类的功能都有可能产生故障
 * 3)问题提出：在编程中，如何正确的使用继承? => 里氏替换原则
 */
public class Liskov {
    public static void main(String[] args) {
        // 测试

        A a = new A();
        System.out.println("11-3="+a.func1(11,3));
        System.out.println("1-8="+a.func1(1,8));

        System.out.println("============================");

        B b = new B();
        System.out.println("11-3="+b.func1(11,3));
        System.out.println("1-8="+b.func1(1,8));
        System.out.println("11+3+9="+b.func2(11,3));


    }
}

// 父类
class A {
    // 返回两个数的差

    public int func1(int num1, int num2) {
        return num1 - num2;
    }
}

// 子类
class B extends A {

    // 这里重写了A类的方法，可能是无意识
    @Override
    public int func1(int num1, int num2) {
        return num1 + num2;
    }

    public int func2(int a, int b){
        return func1(a,b)+9;
    }
}