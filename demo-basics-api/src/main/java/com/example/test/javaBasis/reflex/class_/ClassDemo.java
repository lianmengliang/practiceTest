package com.example.test.javaBasis.reflex.class_;

import com.example.test.javaBasis.reflex.Car;
import com.example.test.javaBasis.reflex.Cat;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

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
        System.out.println("cls:" + cls);
        //2.类名.class, 应用场景：用于参数传递
        Class<Car> cls2 = Car.class;
        System.out.println("cls2:" + cls2);

        // 3.对象.getClass(),应用场景，有对象实例
        Car car = new Car();
        Class cls3 = car.getClass();
        System.out.println("cls3：" + cls3);

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
        System.out.println(type1.getName());
        System.out.println(type2);
        System.out.println(type3.getName());

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
        // 基本数据类型
        Class<Long> cls7 = long.class;
        // void对象
        Class<Void> cls8 = void.class;
        // Class类对象
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
     * 演示通过反射获取类的结构信息
     *
     * @throws {}Exception System.out.println("所有的public修饰的属性(包括本类和父类)："+ Arrays.toString(personClass.getFields()));
     *                     System.out.println("所有属性"+ Arrays.toString(personClass.getDeclaredFields()));
     *                     System.out.println("所有public方法："+ Arrays.toString(personClass.getMethods()));
     *                     System.out.println("所有方法："+ Arrays.toString(personClass.getMethods()));
     *                     System.out.println("所有public的构造器："+ Arrays.toString(personClass.getConstructors()));
     *                     System.out.println("所有构造器："+ Arrays.toString(personClass.getConstructors()));
     *                     System.out.println("包信息："+personClass.getPackage());
     *                     System.out.println("父类信息："+personClass.getSuperclass());
     *                     System.out.println("Class[]形式返回接口信息："+ Arrays.toString(personClass.getInterfaces()));
     *                     System.out.println("以Annotation[]形式返回注解信息："+ Arrays.toString(personClass.getAnnotations()));
     */
    public static void class05() throws Exception {

        Class<?> personClass = Class.forName("com.example.test.javaBasis.reflex.Person");

        System.out.println("全类名：" + personClass.getName());

        System.out.println("简单类名：" + personClass.getSimpleName());

        Field[] fields = personClass.getFields();
        int a = 0;
        for (Field field : fields) {
            System.out.println("所有属性" + (++a) + "：" + field.getName());
        }

        Field[] declaredFields = personClass.getDeclaredFields();
        a = 0;
        for (Field declaredField : declaredFields) {
            System.out.println("所有属性" + (++a) + "：" + declaredField.getName());
        }

        System.out.println("所有public的构造器,不包括父类：" + Arrays.toString(personClass.getConstructors()));
        System.out.println("所有构造器：" + Arrays.toString(personClass.getDeclaredConstructors()));
        System.out.println("父类信息：" + personClass.getSuperclass().getName());

        System.out.println("Class[]形式返回接口信息：" + Arrays.toString(personClass.getInterfaces()));
        System.out.println("以Annotation[]形式返回注解信息：" + Arrays.toString(personClass.getAnnotations()));
    }

    /**
     * @throws {}Exception
     */
    public static void class06() throws Exception {
        Class<?> personClass = Class.forName("com.example.test.javaBasis.reflex.Person");
        Field[] fields = personClass.getFields();
        int a = 0;
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("属性" + (++a) + "："
                    + " 修饰符：" + declaredField.getModifiers()
                    + " 返回类型：" + declaredField.getType()
                    + " 属性名：" + declaredField.getName());
        }
        System.out.println("================================================================");
        a = 0;
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("方法" + (++a) + "："
                    + " 修饰符：" + declaredMethod.getModifiers()
                    + " 返回类型：" + declaredMethod.getReturnType()
                    + " 方法名：" + declaredMethod.getName()
                    + " 参数类型数组：" + Arrays.toString(declaredMethod.getParameterTypes()));
        }


        a = 0;
        Constructor<?>[] constructors = personClass.getDeclaredConstructors();

        for (Constructor<?> constructor : constructors) {
            System.out.println("构造方法" + (++a) + "："
                    + " 修饰符：" + constructor.getModifiers()
                    + " 构造器名称：" + constructor.getName()
                    + " 参数类型数组：" + Arrays.toString(constructor.getParameterTypes()));
        }

    }

    /**
     * 通过反射机制 创建实例
     *
     * @throws {}Exception
     */
    public static void class07() throws Exception {
        // 先获取类的Class对象
        Class<?> aClass = Class.forName("com.example.test.javaBasis.reflex.Cat");

        // 1.通过获取无参构造器 来构造对象
        Object o = aClass.newInstance();
        System.out.println(o);

        // 2.通过获取对应的public构造器 来构造对象
        Constructor<?> constructor = aClass.getConstructor(String.class);
        Object tom = constructor.newInstance("Tom");
        System.out.println(tom);

        // 3.通过非public的有参构造器创建实例 (私有的，保护的)
        Constructor<?> constructor1 = aClass.getDeclaredConstructor(String.class, String.class);
        // 爆破【暴力破解】 使用反射可以访问private构造器
        constructor1.setAccessible(true);
        Object o1 = constructor1.newInstance("Kevin", "蓝色");
        System.out.println(o1);

    }

    /**
     * 通过反射机制 访问类中的成员
     *
     * @throws {}Exception
     */
    public static void class08() throws Exception {

        Class<?> studentClass = Class.forName("com.example.test.javaBasis.reflex.class_.Student");

        // 创建对象  o:运行的类型就是Student
        Object o = studentClass.newInstance();
        System.out.println(o);
        // 使用反射得到ageage 属性对象
        Field age = studentClass.getField("age");
        age.set(o, 88); // 通过反射来操作属性
        System.out.println(o);
        System.out.println("获取age属性值：" + age.get(o));

        // 使用反射操作那么属性， 私有且静态
        Field name = studentClass.getDeclaredField("name");
        // 对name 进行爆破，可以操作private属性
        name.setAccessible(true);
//        name.set(o,"Leo");

        // 因为那么是static属性，因此 o 也可以写null
        name.set(null, "Tom");

        System.out.println(o);
        // 获取属性值
        System.out.println(name.get(o));
        // 只有静态修饰时，才可以用null 获取属性值
        System.out.println(name.get(null));

    }

    /**
     * 通过反射机制 访问类中的方法
     *
     * @throws {}Exception
     */
    public static void class09() throws Exception {
        Class<?> cls = Class.forName("com.example.test.javaBasis.reflex.class_.Student");

        // 创建对象  o:运行的类型就是Student
        Object o = cls.newInstance();
        System.out.println(o);

        // 调用用public的hi方法
//        Method hi = cls.getMethod("hi",String.class);
        Method hi = cls.getDeclaredMethod("hi",String.class);
        hi.invoke(o,"Leo");

        // 调用private static 方法
        Method say = cls.getDeclaredMethod("say", int.class, String.class);
        // 因为say方法是private修饰的，所以需要爆破，原理和前面的构造器和属性一样
        say.setAccessible(true);
        say.invoke(o,100,"^6不6^");
        // 由于say方法是static的，还可以这样调用，可以传入null
        say.invoke(null,200,"帅不帅");

        //在反射中，如果方法有返回值，统一返回Object
        // 但是他运行类型和方法定义的返回类型一致
        Object invoke = say.invoke(null, 666, " Leo");
        System.out.println(invoke.getClass());  //String
    }

    /**
     * 主方法
     *
     * @param args
     * @throws {} Exception
     */
    public static void main(String[] args) throws Exception {
        class03();
    }
}

class Student {
    public int age;
    private static String name;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                '}';
    }

    public void hi(String n) {
        System.out.println("hi ,你好呀~~" + n);
    }


    private static String say(int a, String s) {
        System.out.println(a + s + "-----");
        return a + s + "-----";
    }
}