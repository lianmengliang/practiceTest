package com.example.test.java_basis.iostream.iohomework;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * @Author ： Leo
 * <p>顺序：15
 * @Date : 2021/6/10 18:23
 * @Desc: IO流的作业 （练习）
 */
public class IOHomeWork {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        homework03();
    }

    /**
     * 作业要求：
     * (1)在判断e盘下是否有文件夹mytemp ,如果没有就创建mytemp
     * (2)在e:\mytemp目录下,创建文件 hello.txt
     * (3)如果hello.txt已经存在，提示该文件已经存在，就不要再重复创建了
     * (4)并且在hello.txt 文件中，写入hello,world~
     */
    private static void homework01() throws IOException {
        String filePath = "G:\\mytemp\\";
        File file = new File(filePath);
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.printf("成功创建"+filePath+"文件夹");
            }
        }
        File helloFile = new File(file, "hello.txt");
        if (!helloFile.exists()) {
            if (helloFile.createNewFile()){
                System.out.println(helloFile + "创建成功");
                // 在hello.txt 文件中，写入hello,world~
//                FileWriter writer = new FileWriter(helloFile);
                BufferedWriter writer = new BufferedWriter(new FileWriter(helloFile));
                writer.write("hello,world~");
                writer.close();
            }else{
                System.out.println("创建失败");
            }
        }else{
            System.out.println("文件已经存在，不需要重复创建");
        }


    }

    /**
     * 要求:
     * 使用BufferedReader读取一个文本文件，
     * 为每行加上 行号 ，再连同内容一并输出到屏幕上。
     */
    private static void homework02() {

        String filePath = "G:\\testIO\\story.txt";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8));
            //  br = new BufferedReader(new FileReader(filePath));
            String readLen = null;
            int lineNum = 0;
            while ((readLen = reader.readLine()) != null) {
                System.out.println(++lineNum + readLen);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader!=null){
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 3.编程题
     * (1)要编写一个dog.properties
     * name=tom
     * age=5
     * color=red
     * (2)编写Dog类(name,age,color)创建一个dog对象，
     * 读取dog.properties用相应的内容完成属性初始化,并输出
     */
    private static void homework03() throws IOException, ClassNotFoundException {

        Properties properties = new Properties();

        String filePath = "src\\dog.properties";
        properties.setProperty("name", "tom");
        properties.setProperty("age", "5");
        properties.setProperty("color", "red");


        // 保存
        properties.store(new FileOutputStream(filePath),"hello！dog");


       /* //读取内容
        Properties readProperties = new Properties();
        readProperties.load(new FileReader(filePath));*/


        String name = properties.getProperty("name");
        Integer age = Integer.valueOf(properties.getProperty("age"));
        String color = properties.getProperty("color");

        Integer.parseInt(properties.getProperty("age"));

        Dog dog = new Dog(name, age, color);
        System.out.println(dog);

        String path = "G:\\testIO\\dog.dat";

        //序列化写入到磁盘的文件中
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        oos.writeObject(dog);
        oos.close();
        System.out.println("序列化完成。。。");


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        Dog dog1 = (Dog)ois.readObject();
        System.out.println(dog1);
        System.out.println("反序列化完成。。。");

    }

}


class Dog implements Serializable{
    private String name;

    private Integer age;

    private String color;

    public Dog(String name, Integer age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }


    public Dog() {
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}