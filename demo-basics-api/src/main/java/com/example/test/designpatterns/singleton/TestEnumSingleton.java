package com.example.test.designpatterns.singleton;

/**
 * @Author ： Leo
 * @Date : 2021/3/16 10:17
 * @Desc:
 */
public class TestEnumSingleton {

    public static void main(String[] args) {

        System.out.println(User.getInstance());

        System.out.println(User.getInstance() == User.getInstance());

        EnumSingleton instance = EnumSingleton.INSTANCE;
        System.out.println(instance);
        System.out.println(instance.hashCode());
        instance.sayOk();

        Runtime runtime = Runtime.getRuntime();
        System.out.println("runtime:" + runtime);
    }
}
