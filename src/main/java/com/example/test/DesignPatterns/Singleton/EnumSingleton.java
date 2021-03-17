package com.example.test.DesignPatterns.Singleton;

/**
 * @Author ： Leo
 * @Date : 2021/3/16 10:07
 * @Desc:
 */
public enum EnumSingleton {

    INSTANCE;

    public EnumSingleton getInstance(){
        return INSTANCE;
    }
}
