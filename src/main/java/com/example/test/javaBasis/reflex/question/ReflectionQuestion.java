package com.example.test.javaBasis.reflex.question;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @Author ： Leo
 * @Date : 2021/6/16 18:32
 * @Desc:
 */
@SuppressWarnings("all")
public class ReflectionQuestion {

    public static void main(String[] args) throws Exception{
        demo();
    }

    /**
     * 反射入门 案例
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IOException
     */
    public static void demo() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IOException, NoSuchFieldException {


        Properties properties = new Properties();
        properties.load(new FileReader("src/cls.properties"));

        String clsName = properties.getProperty("classfullpath");
        String methodName = properties.getProperty("method");

        System.out.println(clsName);
        System.out.println(methodName);

        // 1)加载
        Class cls = Class.forName(clsName);
        // 2)通过对象得到加载的类的对象实例
        Object o = cls.newInstance();
        System.out.println("运行的类型为："+o.getClass());
        // 3)通过cls 得到加载类的方法
        Method method = cls.getMethod(methodName);
        // 4)通过method 调用方法，即通过方法对象来实现调用方法
        method.invoke(o);

        // getField不能得到私有的属性,只能获取public的属性
        Field colorName = cls.getField("color");
        System.out.println(colorName.get(o));

        // 获取构造器 ()中可以指定构造参数类型，返回无参构造器
        Constructor constructor = cls.getConstructor();
        System.out.println(constructor);

        // 有形参的构造器
        Constructor constructor1 = cls.getConstructor(String.class, String.class);
        System.out.println(constructor1);

    }

}
