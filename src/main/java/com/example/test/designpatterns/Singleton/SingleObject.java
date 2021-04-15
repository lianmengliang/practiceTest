package com.example.test.designpatterns.Singleton;

/**
 * @Author ： Leo
 * @Date : 2021/3/15 10:15
 * @Desc: 单例模式
 */
public class SingleObject {

    //创建一个SingleObject的一个对象
    private static SingleObject instance = new SingleObject();

    //让构造函数为private,这样做 该类就不会被实例化
    private SingleObject(){
    }

    //获取唯一可用的对象
    public static SingleObject getInstance(){
        return instance;
    }

    public void showMessage(){
        System.out.println("普通单例模式");
        System.out.println("=================================");
    }
}
