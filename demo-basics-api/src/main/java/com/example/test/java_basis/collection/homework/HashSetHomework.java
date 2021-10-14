package com.example.test.java_basis.collection.homework;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @Author ： Leo
 * @Date : 2021/8/17 18:12
 * @Desc: 作业要求：
 */
public class HashSetHomework {
    public static void main(String[] args) {
        homework003();

    }

    /**
     * 作业1：
     * 定义个Employee类，该类包含 name，age成员属性
     * * <p>
     * * 要求：
     * * 1.创建3个Employee对象 放入HashSet中
     * * 2. 当name和age的值相同时，认为是相同员工，不能添加到HashSet集合中
     * <p>
     * 重点：Employee类 勾选name和age属性，重写HashCode和equals 方法。
     */
    public static void homework001() {

        Set set = new HashSet();

        for (int i = 1; i <= 3; i++) {
            set.add(new Employee("leo", 18 + i));
        }

        System.out.println(set);

    }

    /**
     * 作业2：
     * 描述：
     * * 定义一个Student类,该类包含:private成员属性name,sal,birthday(MyDate类型)，
     * * 其中birthday 为 MyDate类型(属性包括: year, month, day),
     * *
     * * 要求:
     * * 1.创建3个Employee 放入 HashSet中
     * * 2.当 name 和 birthday的值相同时，认为是相同员工,不能添加到HashSet集合中
     * <p>
     * 重点：
     * 1. Student类 勾选name和age属性，重写HashCode和equals 方法，
     * 2. 且MyDate类，勾选所有成员属性，重写HashCode和equals 方法(否则 无效)
     */
    public static void homework002() {

        Set set = new HashSet();

        for (int i = 0; i < 3; i++) {
            set.add(new Student("Leo", 1.2 + i, new MyDate(2020, 12, 10)));
        }

        System.out.println(set);
    }


    /**
     * 小练习
     * 产生10个1-20之间的随机数要求随机数不能重复
     * 分析需求：
     * 1）有Random类创建随机数对象
     * 2）需要存储10个随机数,而且不能重复,所以我们用HashSet集合
     * 3）如果HashSet的size是小于10就可以不断的存储,如果大于等于10就停止存储
     * 4）通过Random类中的nextInt(n)方法获取1到20之间的随机数,并将这些随机数存储在HashSet集合中
     * 5）遍历HashSet
     */
    public static void homework003() {

        Random random = new Random();

        HashSet set = new HashSet();

        //存取10个不同的随机数，HashSet保证添加的数据是不一致的
        while (set.size() < 10) {
            // 取随机数
            set.add(random.nextInt(90) + 1);
        }
        for (Object o : set) {
            System.out.println(o);
        }
    }

}

class Employee {

    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Employee employee = (Employee) o;

        if (age != employee.age) {
            return false;
        }
        return name != null ? name.equals(employee.name) : employee.name == null;
    }

    /**
     * 当name和age的值相同时，认为是相同员工，不能添加到HashSet集合中
     *
     * @return
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
}


class Student {
    private String name;
    private double sal;
    private MyDate birthday;

    public Student(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        return birthday != null ? birthday.equals(student.birthday) : student.birthday == null;
    }

    /**
     * 当 name 和 birthday的值相同时，认为是相同员工,不能添加到HashSet集合中
     *
     * @return
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }
}

class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyDate myDate = (MyDate) o;

        if (year != myDate.year) return false;
        if (month != myDate.month) return false;
        return day == myDate.day;
    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + month;
        result = 31 * result + day;
        return result;
    }
}