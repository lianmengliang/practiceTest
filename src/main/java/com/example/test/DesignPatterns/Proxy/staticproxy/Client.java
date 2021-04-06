package com.example.test.DesignPatterns.Proxy.staticproxy;

/**
 * @Author ： Leo
 * @Date : 2021/3/26 12:16
 * @Desc:
 */
public class Client {
    public static void main(String[] args) {
        TeacherDao teacherDao = new TeacherDao();

        TeacherDaoProxy teacherDaoProxy = new TeacherDaoProxy(teacherDao);

        teacherDaoProxy.teach();
    }
}
