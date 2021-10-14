package com.example.test.designpatterns.visitor;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author ： Leo
 * @Date : 2021/4/7 18:19
 * @Desc:
 */
public class Client {
    public static void main(String[] args) {

        // 创建一个ObjectStructure
        ObjectStructure objectStructure = new ObjectStructure();

        objectStructure.attach(new Man());
        objectStructure.attach(new Woman());

        // 成功
        Success success = new Success();
        objectStructure.display(success);

        System.out.println("------------------");
        Fail fail = new Fail();
        objectStructure.display(fail);

        System.out.println("------------------");
        Wait wait = new Wait();
        objectStructure.display(wait);


        ArrayList<Object> objects = new ArrayList<>();
        objects.iterator();

    }
}
