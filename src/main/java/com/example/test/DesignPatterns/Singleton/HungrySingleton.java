package com.example.test.DesignPatterns.Singleton;

/**
 * @Author ： Leo
 * @Date : 2021/3/15 11:47
 * @Desc: 饿汉式 -- 单例模式
 *
 * 优点：没有加锁，执行效率会提高。
 * 缺点：类加载时就初始化，浪费内存。
 */
public class HungrySingleton {

    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton(){}

    /**
     * 简单的 饿汉式 --单例模式
     * @return
     */
    public static HungrySingleton getInstance(){

        System.out.println("饿汉式-单例模式");
        return instance;
    }



}
