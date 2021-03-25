package com.example.test.DesignPatterns.flyweight;

/**
 * @Author ： Leo
 * @Date : 2021/3/25 17:27
 * @Desc:
 */
public class User {

    private String name ;

    public User(String name) {
        super();
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
