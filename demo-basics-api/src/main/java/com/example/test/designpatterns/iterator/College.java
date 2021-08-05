package com.example.test.designpatterns.iterator;

import java.util.Iterator;

/**
 * @Author ： Leo
 * @Date : 2021/4/8 12:11
 * @Desc:
 */
public interface College {
    String getName();

    // 增加系的方法
    void addDepartment(String name, String desc);

    // 返回一个迭代器
    Iterator createIterator();
}
