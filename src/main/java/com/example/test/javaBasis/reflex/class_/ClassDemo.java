package com.example.test.javaBasis.reflex.class_;

import com.example.test.javaBasis.reflex.Car;
import com.example.test.javaBasis.reflex.Cat;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author ： Leo
 * @Date : 2021/6/17 11:47
 * @Desc: Class类特点的 梳理
 * <p>
 * 1.Clss也是类，因此也继承Object类
 * 2.Class类不是new出来的，而是系统创建出来的
 * 3.对于某个类的Clss类对象，在内存中只有一份，因为来只加载一次
 * 4.每个类的实例都会记得自己是由哪个Class实例所生成
 * 5.通过Class类对象可以完整地得到一个类的完整结构，通过一系列API
 * 6.Class的对象时存在 堆的
 * 7.类的字节码二进制数据，是放在方法区的，有的的地方称为类的元数据
 * （包括 方法代码，变量名，方法名，访问权限等等）
 */
public class ClassDemo {


    /**
     * 验证class类的特点
     *
     * @throws {}Exception
     */
    public static void class01() throws Exception {
        // 1）传统的new对象
        Cat cat = new Cat();
        System.out.println(cat.hashCode());
        //2)反射方式
        Class aClass1 = Class.forName("com.example.test.javaBasis.reflex.Cat");
        Class aClass2 = Class.forName("com.example.test.javaBasis.reflex.Cat");

        // hash值一样
        System.out.println(aClass1.hashCode());
        System.out.println(aClass2.hashCode());
    }

    /**
     * 演示Class类 常用方法
     *
     * @throws {}Exception
     */
    public static void class02() throws Exception {

        String classFullPath = "com.example.test.javaBasis.reflex.Car";
        // 获取到Car类，对应的Class对象
        // <?>标识不确定的Java类型
        Class<?> cls = Class.forName(classFullPath);
        // 输出cls  --class com.example.test.javaBasis.reflex.Car
        System.out.println("cls：" + cls);
        // 输出运行类型 --
        System.out.println("运行类型:" + Class.class);
        // 获取包名
        System.out.println("包名：" + cls.getPackage().getName());
        // 得到全类名
        System.out.println("全类名：" + cls.getName());
        // 通过cls创建对象 实例对象
        Car car = (Car) cls.newInstance();
        System.out.println("cls创建实例对象：" + car);

        // 获取属性 brand
        Field brand = cls.getField("brand");
        System.out.println("获取属性：" + brand.get(car));

        //通过反射给属性赋值
        brand.set(car, "奥迪");
        System.out.println("属性赋值：" + brand.get(car));

        // 获取所有的属性
        Field[] fields = cls.getFields();
        int a = 0;
        for (Field f : fields) {
            System.out.println("属性" + (++a) + "：" + f.get(car));
        }
        // 获取方法
        Method helloMethod = cls.getMethod("hello");
        System.out.println("方法名称" + helloMethod.getName());
       /* Method[] methods = cls.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }*/

    }

    /**
     * 演示 获取Class类 对象的方法
     *
     * @throws {}Exception
     */
    public static void class03() throws Exception {

        //1.已知一个类的全类名，且该类在类路径下，可通过Class类的静态方法forName获取
        //
        String classFullPath = "com.example.test.javaBasis.reflex.Car";
        // 获取到Car类，对应的Class对象
        Class<?> cls = Class.forName(classFullPath);
        System.out.println("cls:"+cls);
        //2.类名.class, 应用场景：用于参数传递
        Class<Car> cls2 = Car.class;
        System.out.println("cls2:"+cls2);

        // 3.对象.getClass(),应用场景，有对象实例
        Car car = new Car();
        Class cls3 = car.getClass();
        System.out.println("cls3："+cls3);

        // 4.通过类加载器来获取类的Class对象 （4种加载器）
        //1)先得到类加载器
        ClassLoader classLoader = car.getClass().getClassLoader();
        //2)同类加载器得到Class对象
        Class<?> cls4 = classLoader.loadClass(classFullPath);
        System.out.println(cls4);

       /* System.out.println(cls.hashCode());
        System.out.println(cls2.hashCode());
        System.out.println(cls3.hashCode());
        System.out.println(cls4.hashCode());*/

        // 5.基本数据按如下方方式得到Class类对象
        Class<Integer> cls5 = int.class;
        Class<Double> cls6 = double.class;

        System.out.println(cls5);
        System.out.println(cls6);
        // 6.基本数据类型对应的包装类，可以通过.TYPE 得到Class对象
        Class<Integer> type = Integer.TYPE;
        Class<Integer> type1 = Integer.class;
        Class<Double> type2 = Double.TYPE;
        Class<Double> type3 = Double.class;
        System.out.println(type);
        System.out.println(type1);
        System.out.println(type2);
        System.out.println(type3);

        System.out.println(cls5.hashCode());
        System.out.println(type.hashCode());
        System.out.println(type1.hashCode());
        System.out.println("--------------------------------");
        System.out.println(cls6.hashCode());
        System.out.println(type2.hashCode());
        System.out.println(type3.hashCode());
    }

    /**
     * 演示 那些类型有Class对象
     *
     * @throws {}Exception
     */
    public static void class04() throws Exception {
        // 外部类
        Class<String> cls1 = String.class;
        // 接口
        Class<Serializable> cls2 = Serializable.class;
        // 数组
        Class<Integer[]> cls3 = Integer[].class;
        // 二维数组
        Class<int[][]> cls4 = int[][].class;
        // 注解
        Class<Deprecated> cls5 = Deprecated.class;
        // 枚举
        Class<Thread.State> cls6 = Thread.State.class;

        Class<Long> cls7 = long.class;

        Class<Void> cls8 = void.class;

        Class<Class> cls9 = Class.class;

        System.out.println(cls1);
        System.out.println(cls2);
        System.out.println(cls3);
        System.out.println(cls4);
        System.out.println(cls5);
        System.out.println(cls6);
        System.out.println(cls7);
        System.out.println(cls8);
        System.out.println(cls9);

    }
    /**
     * 主方法
     *
     * @param args
     * @throws {} Exception
     */
    public static void main(String[] args) throws Exception {
        class04();

    }
}
