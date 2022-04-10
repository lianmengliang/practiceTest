package com.example.test.java_basis.generic;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * lianmengliang
 * <p>
 * 2022-03-27 17:22
 *
 * 泛型使用细节：
 * 1.泛型 T,E只能是引用类型，不能是int这种数据类型
 * 2.在给泛型指定具体类型后，可以传入该类型的或者其子类
 *
 */
public class GenericTest {
    public static void main(String[] args) {

    }


    /**
     *
     */
    public static void generic001() {
//1。
//        List<int> list = new ArrayList<int>();
        List<Integer> integers = new ArrayList<>();


        //2。
        Pig<Test> pig = new Pig<>(new Test());
        Pig<Test> pig1 = new Pig<>(new Test001());

        //3。该集合的类型 默认为 Object
        List list = new ArrayList<>();

    }
}




class Test{

}

class Test001 extends Test{

}


class Pig<E>{
    E e;

    public Pig(E e) {
        this.e = e;
    }

}