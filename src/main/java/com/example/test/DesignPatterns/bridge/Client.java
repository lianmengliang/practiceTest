package com.example.test.DesignPatterns.bridge;

/**
 * @Author ： Leo
 * @Date : 2021/3/24 15:52
 * @Desc:
 */
public class Client {

    public static void main(String[] args) {


        // 获取折叠式手机（样式+品牌）

        Phone phone = new FoldedPhone(new XiaoMi());
        phone.open();
        phone.close();
        phone.call();

        System.out.println("======================");

        FoldedPhone phone1 = new FoldedPhone(new Vivo());

        phone1.open();
        phone1.close();
        phone1.call();

        System.out.println("======================");


        UpRightPhone phone2 = new UpRightPhone(new XiaoMi());

        phone2.open();
        phone2.close();
        phone2.call();

        // Driver
    }
}
