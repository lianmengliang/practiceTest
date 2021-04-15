package com.example.test.designpatterns.Proxy.dynamic;

/**
 * @Author ： Leo
 * @Date : 2021/3/26 12:13
 * @Desc:
 */
public class TeacherDao implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println("老师正在授课中。。。");
    }

    @Override
    public void sayHello(String name) {
        System.out.println(name + "老师正在向大家问好...");
    }
}
