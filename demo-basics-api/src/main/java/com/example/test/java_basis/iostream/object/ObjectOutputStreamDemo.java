package com.example.test.java_basis.iostream.object;

import java.io.*;

/**
 * @Author ： Leo
 * <p>顺序：10
 * @Date : 2021/6/9 15:47
 * @Desc:
 * 1.使用ObjectOutputStream 序列化保存信息 文件 到本地磁盘上
 * 2.使用ObjectInputStream 反序列化本地文件 到程序中
 *
 * 需要注意点：
 * 1)读写顺序要求一致
 * 2)要求实现序列化或反序列化对象,需要实现 Serializable
 * 3)序列化的类中建议添加SerialVersionUID,为了提高版本的兼容性
 * 4)序列化对象时，默认将里面所有属性都进行序列化，但除了static或transient修饰的成员
 * 5)序列化对象时，要求里面属性的类型也需要实现序列化接口
 * 6)序列化具备可继承性,也就是如果某类已经实现了序列化，则它的所有子类也已经默认实现了序列化
 */
public class ObjectOutputStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        objectOutputStream();
        objectIntputStream();
    }

    /**
     * 使用ObjectOutputStream 序列化保存信息 文件 到本地磁盘上
     *
     * @throws {IOException}
     */
    private static void objectOutputStream() throws IOException {
        String filePath = "E:\\data.dat";

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));

        // 序列化数据到 E:\data.dat
        // 下面这些数据类型都会转成包装类，而包装类都实现了Serializable接口
        oos.writeInt(100);
        oos.writeBoolean(true);
        oos.writeChar('A');
        oos.writeDouble(10.5);
        // 这里UTF就是指 字符串
        oos.writeUTF("Leo打怪兽");

        Dog dog = new Dog("旺财", 3);
        oos.writeObject(dog);

        // 关闭流
        oos.close();
        System.out.println("保存完毕-(序列化形式)");
    }

    /**
     * 使用ObjectInputStream 反列化本地文件 到程序中
     */
    private static void objectIntputStream() throws IOException, ClassNotFoundException {
        String filePath = "E:\\data.dat";

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));

        // 读取
        // 1. 读取（反序列化）的顺序需要和你保存数据（序列化）的顺序一致
        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());

        // dog的编译类型是Object， dog的运行类型是Dog
        Object dog = ois.readObject();
//        dog.notify();
        System.out.println("运行类型=" + dog.getClass());
        System.out.println("dog信息" + dog);

        // 这里是特别重要的细节：
        // 1.如果我们希望调用Dog的方法，需要向下转型
        // 2.需要我么那将Dog类的带你故意，放在可以引用的位置
        // 要么Dog类放在同一个包下， 要么就写成 公告类，用public修饰Dog类

        Dog dog1 = (Dog) dog;
        dog1.print();

        // 关闭 外层流
        ois.close();
    }
}

class Dog implements Serializable {
    private String name;
    private int age;

    /**
     * 序列化对象时：
     * 默认将里面所有属性都进行序列化，但除了static和 transient修饰的成员变量
     */
    private static String nation;
    private static String color;

    /**
     * 序列化时，也要求里面的属性也需要实现序列化接口
     */
    private  Master master = new Master();

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }


    /**
     * 序列化的版本号，可以提高兼容性
     */
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}' + ">" + nation + "-" + color + "-" + master;
    }

    public void print() {
        System.out.println("这是一只狗");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
