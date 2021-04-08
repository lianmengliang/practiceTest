package com.example.test.DesignPatterns.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @Author ： Leo
 * @Date : 2021/4/8 12:04
 * @Desc:
 */
public class InfoCollegeIterator implements Iterator {

    /**
     * 信息工程学院是以List方式存放的
     */
    private List<Department> departmentList;
    // 索引
    private int index = -1;

    public InfoCollegeIterator(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    /**
     * 判断list中还没有下一个元素
     * @return
     */
    @Override
    public boolean hasNext() {
        if (index >= departmentList.size() - 1) {
            return false;
        } else {
            index += 1;
            return true;
        }
    }

    @Override
    public Object next() {
        Department department = departmentList.get(index);
        return department;
    }


    /**
     *  空实现
     */
    @Override
    public void remove() {

    }

}
