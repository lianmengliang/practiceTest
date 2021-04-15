package com.example.test.designpatterns.iterator;

import java.util.Iterator;
import java.util.List;

/**
 * @Author ： Leo
 * @Date : 2021/4/8 12:22
 * @Desc:
 */
public class OutPutImpl {

    /**
     * 学院集合
     */
    private List<College> collegeList;

    public OutPutImpl(List<College> collegeList) {
        this.collegeList = collegeList;
    }

    /**
     * 遍历所有学院
     * 然后调用printDepartment输出各个学院的系
     */
    public void printCollege() {
        // 从collegeList取出所有学院，Java中的List已经实现Iterator
        Iterator<College> iterator = collegeList.iterator();
        while (iterator.hasNext()) {
            // 取出一个学院
            College college = iterator.next();
            System.out.println("---" + college.getName() + "---");
            // 得到相应的迭代器
            printDepartment(college.createIterator());
        }
    }

    /**
     * 输出 ==> 学院输出系
     *
     * @param iterator
     */
    public void printDepartment(Iterator iterator) {
        while (iterator.hasNext()) {
            Department d = (Department) iterator.next();
            System.out.println(d.getName());
        }
    }
}
