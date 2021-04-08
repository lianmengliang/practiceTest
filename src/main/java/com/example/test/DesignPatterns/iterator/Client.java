package com.example.test.DesignPatterns.iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author ： Leo
 * @Date : 2021/4/8 14:25
 * @Desc:
 */
public class Client {
    public static void main(String[] args) {

        // 创建学院集合
        ArrayList<College> collegeList = new ArrayList<>();

        // 创建单个学院
        Computercollege computercollege = new Computercollege();
        InfoCollege infoCollege = new InfoCollege();
        // 把单个学院放到集合中
        collegeList.add(computercollege);
        collegeList.add(infoCollege);

        // 创建一个输出者
        OutPutImpl outPut = new OutPutImpl(collegeList);
        outPut.printCollege();

    }
}
