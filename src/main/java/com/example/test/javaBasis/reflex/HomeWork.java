package com.example.test.javaBasis.reflex;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author ： Leo
 * @Date : 2021/6/21 14:50
 * @Desc:
 */
public class HomeWork {


    /**
     * 作业 1：
     */
    public static void homework1() throws Exception {

        // 初始化类实例
        Class<PrivateTest> aClass= PrivateTest.class;

        PrivateTest test = aClass.newInstance();

        System.out.println(test.getName());

        // 获取属性
        Field name = aClass.getDeclaredField("name");
        // 设置爆破
        name.setAccessible(true);
        // 重新赋值
        name.set(test, "hello,Leo！");

        Method getName = aClass.getMethod("getName");
        Object invoke = getName.invoke(test);

        System.out.println(invoke);

    }

    /**
     * 作业 2：
     */
    public static void homework2() throws Exception {
        // 初始化对象
        Class<File> aClass = File.class;

        // 获取所有的构造方法
        Constructor<?>[] constructors = aClass.getDeclaredConstructors();
        int a = 0;
        for (Constructor<?> constructor : constructors) {
            System.out.println(++a + "：" + constructor.getName()+"--"+constructor);
        }

        //单独得到 以String字符串为参数的 构造器
        Constructor<?> constructor = aClass.getDeclaredConstructor(String.class);
        Object o = constructor.newInstance("E:\\mynew.txt");
        File file = (File)o;
        if (file.createNewFile()){
            System.out.println("文件创建成功");
        }else{
            System.out.println("文件创建失败");
        }



    }

    /**
     * 主方法
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        homework1();
    }

}

class PrivateTest {
    private String name = "hellokitty";

    public String getName() {
        return name;
    }


}