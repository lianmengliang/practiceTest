package com.example.test.designpatterns.Singleton;

/**
 * @Author ： Leo
 * @Date : 2021/3/15 11:41
 * @Desc: 懒汉式 --单例模式 （）
 *
 *
 */
public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {
    }

    /**
     * 是否多线程安全，取决于是否加synchronized关键字
     * @return
     */
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        System.out.println("懒汉式-单例模式");
        return instance;
    }

}
