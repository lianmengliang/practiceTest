package com.example.test.DesignPatterns.bridge;

/**
 * @Author ： Leo
 * @Date : 2021/3/24 16:03
 * @Desc:
 */
public class UpRightPhone extends Phone {

    public UpRightPhone(Brand brand) {
        super(brand);
    }

    @Override
    protected void open(){
        super.open();
        System.out.println("直立式手机");
    }
    @Override
    protected void close(){
        super.close();
        System.out.println("直立式手机");
    }
    @Override
    protected void call(){
        super.call();
        System.out.println("直立式手机");
    }
}
