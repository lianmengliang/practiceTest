package com.example.test.java_basis.generic.homework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * lianmengliang
 * <p>
 * 2022-03-27 17:43
 */
@SuppressWarnings("all")
public class GenericHomeWork001 {


    public static void main(String[] args) {
        test001();
    }


    public static void test001() {

        List<Employee> list = new ArrayList<Employee>();

        Employee employee1 = new Employee();
        employee1.setName("Leo");
        employee1.setSal(20000.0);
        employee1.setMyDate(new MyDate(1996, 6, 20));


        Employee employee2 = new Employee();
        employee2.setName("Leo");
        employee2.setSal(20000.0);
        employee2.setMyDate(new MyDate(1996, 6, 10));


        Employee employee3 = new Employee();
        employee3.setName("Alice");
        employee3.setSal(9000.0);
        employee3.setMyDate(new MyDate(2001, 3, 12));

        list.add(employee1);
        list.add(employee2);
        list.add(employee3);

        list.forEach(t -> System.out.println(t));


        System.out.println("按照规则排序后。。。");
        list.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (!(o1 instanceof Employee && o2 instanceof Employee)) {
                    System.out.println("元素类型不是Employee");
                    return 0;
                }

                //按照name
                int compareToName = o1.getName().compareTo(o2.getName());
                if (compareToName != 0) {
                    return compareToName;
                }

                //按照薪水
                int compareToSal = o1.getSal().compareTo(o2.getSal());
                if (compareToSal != 0) {
                    return compareToSal;
                }

                return o1.getMyDate().compareTo(o2.getMyDate());
            }
        });

        list.forEach(t -> System.out.println(t));


    }
}
