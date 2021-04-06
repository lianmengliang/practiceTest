package com.example.test.DesignPatterns.Proxy.dynamic;

/**
 * @Author ： Leo
 * @Date : 2021/3/26 14:24
 * @Desc:
 */
public class Client {

    public static void main(String[] args) {

        ITeacherDao target = new TeacherDao();

        ITeacherDao instance= (ITeacherDao)new ProxyFactory(target).getProxyInstance();

//        ITeacherDao instance = (ITeacherDao) proxyFactory.getProxyInstance();
//        Object proxyInstance = proxyFactory.getProxyInstance();
//        proxyInstance
        // proxyInstance=class com.sun.proxy.$Proxy0 内存中动态生成了代理对象
        System.out.println("proxyInstance: "+instance.getClass());

        instance.teach();

        System.out.println("------------");
        instance.sayHello("Leo");
    }
}
