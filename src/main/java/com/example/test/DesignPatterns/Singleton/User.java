package com.example.test.DesignPatterns.Singleton;

/**
 * @Author ： Leo
 * @Date : 2021/3/16 10:08
 * @Desc:
 */
public class User {

    private User() {
    }


    /**
     * 定义一个静态枚举类
     */
    static enum SingletonEnum {
        // 创建一个枚举对象，该对象天生为单例
        INSTANCE;
        private User user;

        // 私有化枚举的构造函数
        private SingletonEnum() {
            user = new User();
        }

        public User getInstance() {
            return user;
        }
    }

    /**
     * 对外暴露一个获取User对象的静态方法
     *
     * @return
     */
    public static User getInstance() {
        return SingletonEnum.INSTANCE.getInstance();
    }

}
