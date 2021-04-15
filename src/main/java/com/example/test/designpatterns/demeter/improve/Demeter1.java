package com.example.test.designpatterns.demeter.improve;

/**
 * @Author ： Leo
 * @Date : 2021/3/17 15:30
 * @Desc:
 */


import java.util.ArrayList;
import java.util.List;

/**
 * 客户端
 */
public class Demeter1 {
    public static void main(String[] args) {
        SchoolManager schoolManager = new SchoolManager();

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

    public void printAllCollegeEmployee() {
        //获取学院员工
        List<CollegeEmployee> cempList = this.getAllEmployee();
        System.out.println("------学院员工--------");
        for (CollegeEmployee employee : cempList) {
            System.out.println(employee.getId());
        }

    }
}

/**
 * 学校管理类
 * <p>
 * 分析 SchoolManager 类的直接朋友类有哪些 Employee、CollegeManager
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
        sub.printAllCollegeEmployee();

        //获取到学校总部员工
        List<Employee> empList = this.getAllEmployee();
        System.out.println("-------学校总部员工-------");
        for (Employee employee : empList) {
            System.out.println(employee.getId());
        }
    }


}


