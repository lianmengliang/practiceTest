package com.example.test.designpatterns.liskov.improve;

/**
 * @Author ： Leo
 * @Date : 2021/3/17 11:54
 * @Desc:
 */
public class Liskov1 {
    public static void main(String[] args) {
        // 测试

        A a = new A();
        System.out.println("11-3=" + a.func1(11, 3));
        System.out.println("1-8=" + a.func1(1, 8));

        System.out.println("============================");

        B b = new B();
        System.out.println("11-3=" + b.func3(11, 3));
        System.out.println("1+8=" + b.func1(1, 8));
        System.out.println("11+3+9=" + b.func2(11, 3));


    }
}

//一个更加基础的类
class Base {
    //把更加基础的方法和成员写到 Base 类
}

// 父类
class A extends Base {
    // 返回两个数的差

    public int func1(int num1, int num2) {
        return num1 - num2;
    }
}

// 子类
class B extends Base {
    // 如果B需要使用A类的方法， 使用组合关系
    private A a = new A();

    // 这里重写了A类的方法，可能是无意识
    public int func1(int num1, int num2) {
        return num1 + num2;
    }

    public int func2(int a, int b) {
        return func1(a, b) + 9;
    }

    //我们仍然想使用A的方法
    public int func3(int a, int b) {
        return this.a.func1(a, b);
    }
}