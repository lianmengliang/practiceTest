package com.example.test.java_basis.method;

/**
 * lianmengliang
 * <p>
 * 4/30/22 9:52 PM
 */
public class TestDemo001 {
    public static void main(String[] args) {


        T t = new T();

        double a = 3;

        int b = 1 * 7;
        double v = Math.PI * a * a;


    }
}


class T{

     String name;


    public T(){
        this("hello");
        System.out.println("调用无参构造器。。。");
    }

    public T(String name){
        System.out.println("调用的有参构造器。。。");
    }

}