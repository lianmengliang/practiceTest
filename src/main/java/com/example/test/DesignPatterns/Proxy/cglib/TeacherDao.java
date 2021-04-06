package com.example.test.DesignPatterns.Proxy.cglib;


/**
 * @Author ： Leo
 * @Date : 2021/3/26 12:13
 * @Desc:
 */
public class TeacherDao {
    public String teach() {
        System.out.println("老师正在授课中。。。");

        return "hello,I'm teaching";
    }

    public void sayHello(String name) {
        System.out.println(name + "老师正在向大家问好...");
    }
}
