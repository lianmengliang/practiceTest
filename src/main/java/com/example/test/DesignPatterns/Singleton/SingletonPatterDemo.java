package com.example.test.DesignPatterns.Singleton;

/**
 * @Author ： Leo
 * @Date : 2021/3/15 10:58
 * @Desc:
 */
public class SingletonPatterDemo {

    public static void main(String[] args) {
        //不合法的构造函数
        //编译时错误：构造函数SingleObject是不可见的

        //获取唯一可用的对象
        SingleObject instance = SingleObject.getInstance();
        instance.showMessage();

        // 饿汉式-单例模式
        HungrySingleton instance1 = HungrySingleton.getInstance();
        // 懒汉式-单例模式
        LazySingleton instance2 = LazySingleton.getInstance();

        // 双重锁/双重校验锁 实现单例模式
        Singleton singleton2 = Singleton.getSingleton();

        // 登记式/静态内部类实现单例模式
        Singleton singleton1 = Singleton.getInstance();
    }


}
