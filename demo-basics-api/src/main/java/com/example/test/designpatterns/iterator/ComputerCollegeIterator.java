package com.example.test.designpatterns.iterator;

import java.util.Iterator;

/**
 * @Author ： Leo
 * @Date : 2021/4/8 11:58
 * @Desc:
 */
public class ComputerCollegeIterator implements Iterator {

    /**
     * 这里我们需要知道Department是以怎样的方式存放
     */
    private Department[] departments;
    /**
     * 遍历的位置
     */
    private int positon = 0;

    /**
     * 构造器
     *
     * @param departments
     */
    public ComputerCollegeIterator(Department[] departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        if (positon >= departments.length || departments[positon] == null) {
            return false;
        } else {
            return true;
        }

    }

    @Override
    public Object next() {
        Department department = departments[positon];
        positon += 1;

        return department;
    }

    // 删除的方法，默认为空实现
    @Override
    public void remove() {

    }

}
