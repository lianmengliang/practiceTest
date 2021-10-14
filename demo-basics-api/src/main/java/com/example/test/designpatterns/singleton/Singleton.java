package com.example.test.designpatterns.singleton;

/**
 * @Author ： Leo
 * @Date : 2021/3/15 11:51
 * @Desc: 单例模式的变形
 * 1.双重锁/双重校验锁
 * 2.登记式/静态内部类实现单例模式
 */
public class Singleton {
    /**
     * volatile的关键字的作用
     * 1.保证可见性，不保证原子性
     * 2.禁止指令重排
     */

    private volatile static Singleton singleton;

    private Singleton() {
    }

    /**
     * 双重锁/双重校验锁 （DCL）
     *
     * Desc:
     * 这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
     * @return
     */
    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        System.out.println("双重锁/双重校验锁 实现单例模式");
        return singleton;
    }



    //2.登记式/静态内部类

    /**
     * 静态内部类
     */
    private static class SingletonHolder{
        private static final Singleton SINGLETON = new Singleton();
    }

    /**
     * 实现方法
     * @return
     */
    public static final Singleton getInstance(){
        System.out.println("登记式/静态内部类实现单例模式");
        return SingletonHolder.SINGLETON;
    }


}
