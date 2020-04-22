package com.example.practice;

import com.example.practice.model.Person;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author ： leo
 * @Date :2020/4/22 12:17
 */
public class LambdaTest {
    public static void main(String[] args) {
        int sum = sum(3);
        System.out.println(sum);
    }

    public static int sum (int n){
        if(n==1){
            return n;
        }
        return n * sum(n-1);
    }

    /**
     * Lambda 表达式有参数有返回值的练习
     * 需求:使用数组存储多个 Person 对象 对数组中的 Person对象使用 Arrays 的 sort 方法通过年龄进行升序 排序
     */
    public static void testArray(){
        Person[] arr = {
                new Person("柳岩",38),
                new Person("迪丽热巴",18),
                new Person("古力娜扎",19) };

        // 常规方法排序
        Arrays.sort(arr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        });

        // Lambda表达式
        Arrays.sort(arr,(Person o1,Person o2)-> {return o1.getAge() - o2.getAge(); });

        //优化Lamdba表达式
        Arrays.sort(arr,(o1,o2)->o1.getAge()-o2.getAge());

        //最终优化Lambda表达式
        Arrays.sort(arr,Comparator.comparing(Person::getAge));

        String a = "";

        File file = new File("C:/");

        try {
            //创建文件
            boolean newFile = file.createNewFile();

            //创建文件夹
            boolean mkdir = file.mkdir();
            //可创建多级文件夹
            boolean mkdirs = file.mkdirs();
            //遍历文件夹 目录功能
            String[] list = file.list();

            boolean delete = file.delete();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
