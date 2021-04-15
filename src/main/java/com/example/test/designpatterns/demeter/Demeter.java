package com.example.test.designpatterns.demeter;

/**
 * @Author ： Leo
 * @Date : 2021/3/17 15:30
 * @Desc: 迪米特法则
 * 基本介绍
 * 1)一个对象应该对其他对象保持最少的了解
 *
 * 2)类与类关系越密切，耦合度越大
 *
 * 3)迪米特法则(Demeter Principle)又叫最少知道原则，即一个类对自己依赖的类知道的越少越好。也就是说，对于被依赖的类不管多么复杂，都尽量将逻辑封装在类的内部。对外除了提供的 public 方法，不对外泄露任何信息
 *
 * 4)迪米特法则还有个更简单的定义：只与直接的朋友通信
 *
 * 5)直接的朋友：每个对象都会与其他对象有耦合关系，只要两个对象之间有耦合关系，我们就说这两个对象之间是朋友关系。耦合的方式很多，依赖，关联，组合，聚合等。其中，我们称出现成员变量，方法参数，方法返回值中的类为直接的朋友，而出现在局部变量中的类不是直接的朋友。也就是说，陌生的类最好不要以局部变量的形式出现在类的内部。
 *
 */


import java.util.ArrayList;
import java.util.List;

/**
 * 客户端
 */
public class Demeter {
    public static void main(String[] args) {
        // 创建一个SchoolManager对象
        SchoolManager schoolManager = new SchoolManager();

        //输出CollegeEmployee
        schoolManager.printAllEmployee(new CollegeManager());
    }
}

/**
 * 学校总部员工类
 */
class Employee {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

/**
 * 学院的员工类
 */
class CollegeEmployee {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

/**
 * 管理学院员工的 管理类
 */
class CollegeManager {

    //返回学院的所有员工
    public List<CollegeEmployee> getAllEmployee() {

        List<CollegeEmployee> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            CollegeEmployee employee = new CollegeEmployee();
            employee.setId("学院员工id=" + i);
            list.add(employee);
        }

        return list;
    }
}

/**
 * 学校管理类
 * <p>
 * 分析 SchoolManager 类的直接朋友类有哪些？ Employee、CollegeManager
 * CollegeEmployee 不是 直接朋友 而是一个陌生类，这样违背了 迪米特法则
 */
class SchoolManager {
    // 返回学校总部的员工
    public List<Employee> getAllEmployee() {

        List<Employee> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Employee employee = new Employee();
            employee.setId("学校的总员工id=" + i);
            list.add(employee);
        }

        return list;
    }

    void printAllEmployee(CollegeManager sub) {
        /***
         * 分析问题
         * 1.这里的CollegeEmployee不是SchoolManager的直接朋友
         * 2.CollegeEmployee是以局部变量方式出现在SchoolManager
         * 3.违反了 迪米特法则
         */

        //获取学院员工
        List<CollegeEmployee> cempList = sub.getAllEmployee();
        System.out.println("------学院员工--------");
        for (CollegeEmployee employee : cempList) {
            System.out.println(employee.getId());
        }

        //获取到学校总部员工
        List<Employee> empList = this.getAllEmployee();
        System.out.println("-------学校总部员工-------");
        for (Employee employee : empList) {
            System.out.println(employee.getId());
        }
    }


}


