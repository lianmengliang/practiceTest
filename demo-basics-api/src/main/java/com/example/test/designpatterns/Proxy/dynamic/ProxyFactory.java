package com.example.test.designpatterns.Proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author ： Leo
 * @Date : 2021/3/26 14:10
 * @Desc:
 */
public class ProxyFactory {

    // 维护一个目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 给目标对象生成一个代理对象
     * <p>
     * newProxyInstance(ClassLoader loader,Class<?>[] interfaces, InvocationHandler h)
     * 方法解释：
     * 1.ClassLoader loader：指定当前目标对象使用的类加载器，获取加载器的方法固定
     * 2.Class<?>[] interfaces：目标对象实现的接口类型，使用泛型方法确认类型
     * 3.InvocationHandler h：事情处理，执行目标对象的方法时，会触发事情处理器放啊，
     * 会把当前执行的目标对象方法作为参数传入
     *
     * @return
     */
    public Object getProxyInstance() {

        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("jdk代理开始。。。");
                    Object result = method.invoke(target, args);
                    System.out.println("jdk代理结束");
                    return result;
                });
    }
}
