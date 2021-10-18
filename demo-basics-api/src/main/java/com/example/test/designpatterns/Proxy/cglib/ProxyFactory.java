package com.example.test.designpatterns.Proxy.cglib;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author ： Leo
 * @Date : 2021/3/26 14:10
 * @Desc:
 */
@Slf4j
public class ProxyFactory implements MethodInterceptor {

    // 维护一个目标对象
    private Object target;

    /**
     * 构造器 传入一个被代理的对象
     * @param target
     */
    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 返回一个代理对象：是target对象的代理对象
     * @return
     */
    public Object getProxyInstance(){
        // 1.创建一个工具类
        Enhancer enhancer = new Enhancer();
        // 2.设置父类
        enhancer.setSuperclass(target.getClass());
        // 3.设置回调函数
        enhancer.setCallback(this);
        // 4.创建子类对象，即代理对象
        return enhancer.create();
    }

    /**
     * 重写intercept方法，会调用目标对象的方法
     * @param o
     * @param method
     * @param args
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib代理模式~~开始");

       /* log.info("对象：{}\n",o);
        log.info("使用方法：{}\n",method);
        log.info("参数：{}\n",args);
        log.info("代理方法：{}\n",methodProxy);
*/
        Object invokeResult = method.invoke(target, args);
        log.info("返回结果：{}\n",invokeResult);
        System.out.println("Cglib代理模式~~提交");
        return invokeResult;
    }
}
