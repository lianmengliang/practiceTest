package com.example.test.designpatterns.Proxy.cglib;

/**
 * @Author ： Leo
 * @Date : 2021/3/26 18:28
 * @Desc:
 */
public class Client {
    public static void main(String[] args) {

        TeacherDao target = new TeacherDao();

        TeacherDao proxyInstance = (TeacherDao) new ProxyFactory(target).getProxyInstance();

        //执行代理对象的方法，触发intercept方法，从而实现对目标对象的调用
        System.out.println("-------------------------------------------------------");
        String teach = proxyInstance.teach();
        System.out.println("teach:"+ teach);

        System.out.println("----------------------------------------------------------");
        proxyInstance.sayHello("Leo");

    }

}
