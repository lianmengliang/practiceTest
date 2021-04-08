package com.example.test.DesignPatterns.visitor;

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
        objectStructure.attach(new Weman());

        // 成功
        Success success = new Success();
        objectStructure.display(success);

        System.out.println("------------------");
        Fail fail = new Fail();
        objectStructure.display(fail);

        System.out.println("------------------");
        Wait wait = new Wait();
        objectStructure.display(wait);

    }
}
