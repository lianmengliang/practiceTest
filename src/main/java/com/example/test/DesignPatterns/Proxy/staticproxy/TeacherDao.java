package com.example.test.DesignPatterns.Proxy.staticproxy;

/**
 * @Author ： Leo
 * @Date : 2021/3/26 12:13
 * @Desc:
 */
public class TeacherDao implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println("授课中。。。");
    }
}
