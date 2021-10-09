package com.example.test.JDK8Code;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author ： Leo
 * @Date : 2021/10/8 15:17
 * @Desc: Optional的使用
 */
public class testOptional {

    public static List<Student> initData() {
        Student s1 = new Student("张三", 19, 80);
        Student s2 = new Student("李四", 19, 50);
        Student s3 = new Student("王五", 23, null);
        Student s4 = new Student("赵六", 16, 90);
        Student s5 = new Student("钱七", 18, 99);
        Student s6 = new Student("孙八", 20, 40);
        Student s7 = new Student("吴九", 21, 88);
        return Arrays.asList(s1, s2, s3, s4, s5, s6, s7);
    }

    /**
     * 选出年龄大于等于18，参加过考试并且成绩大于80的人去参加比赛
     */
    public void testOptional(){
        List<Student> students = initData();

        // 第一种方法
        for (Student student : students) {
            Optional<Student> studentOptional = Optional.of(student);
            Integer socre = studentOptional.filter(s -> s.getAge() >= 18).map(Student::getScore).orElse(0);
            if (socre>80){
                System.out.println("入选：" + student.getName());
            }
        }

        // 第二种方法

        students.forEach(s->{
            if (s.getAge()>=18 && s.getScore()!=null && s.getScore()>80){
                System.out.println("入选：" + s.getName());
            }
        });

        //第三种方法
        List<String> collect = students.stream().filter(s -> Optional.ofNullable(s.getScore()).isPresent()).filter(s -> s.getAge() >= 18 && s.getScore() > 80).map(Student::getName).collect(Collectors.toList());


        Optional<List<Student>> students1 = Optional.of(students);


    }



    /**
     * 主方法
     * @param args
     */
    public static void main(String[] args) {


    }


}


@Data
class Animal {

    private String name;
    private int age ;
    private String colour;

}

@Data
class Student {
    private String name;
    private Integer age ;
    private Integer score ;

    public Student(String name, Integer age, Integer score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }
}