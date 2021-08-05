package com.example.test.javaBasis.reflex;

import java.lang.reflect.Method;

/**
 * @Author ： Leo
 * @Date : 2021/6/17 11:06
 * @Desc: 测试 反射的性能
 */
@SuppressWarnings("all")
public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        m1();
        m2();
        m3();
    }


    /**
     * 传统方法 测试
     * 传统方法耗时：5
     * 反射耗时：1462
     */
    public static void m1() {
        Cat cat = new Cat();
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            cat.hi();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("传统方法耗时：" + (endTime - startTime));

    }

    /**
     * 测试反射 性能
     */
    public static void m2() throws Exception {

        Class<?> cls = Class.forName("com.example.test.javaBasis.reflex.Cat");
        Object o = cls.newInstance();
        Method method = cls.getMethod("hi");

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            method.invoke(o);
        }
        long endTime = System.currentTimeMillis();

        System.out.println("反射耗时：" + (endTime - startTime));

    }


    /**
     * 提高性能的做法： 就是反射的对象在使用时取消访问检查，提高反射的效率
     * @throws Exception
     */
    public static void m3() throws Exception{
        Class cls = Class.forName("com.example.test.javaBasis.reflex.Cat");
        Object o = cls.newInstance();
        Method method = cls.getMethod("hi");
        // 取消访问检查，提高反射的效率
        method.setAccessible(true);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            method.invoke(o);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("提高性能后反射耗时：" + (endTime - startTime));
    }
}
