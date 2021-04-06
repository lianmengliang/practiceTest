package com.example.test.DesignPatterns.Proxy.staticproxy;

/**
 * @Author ： Leo
 * @Date : 2021/3/26 12:13
 * @Desc:
 */
public class TeacherDaoProxy implements ITeacherDao {

    private ITeacherDao target;

    public TeacherDaoProxy(ITeacherDao target) {
        this.target = target;
    }

    @Override
    public void teach() {
        System.out.println("开始代理,完成某些操作。。");
        target.teach();
        System.out.println("代理提交。。。");
    }
}
