package com.example.test.designpatterns.bridge;

/**
 * @Author ： Leo
 * @Date : 2021/3/24 15:48
 * @Desc:
 */
public class FoldedPhone extends Phone {


    public FoldedPhone(Brand brand) {
        super(brand);
    }

    @Override
    public void open(){
        super.open();
        System.out.println("折叠式手机");
    }
    @Override
    public void close(){
        super.close();

        System.out.println("折叠式手机");
    }
    @Override
    public void call(){
        super.call();
        System.out.println("折叠式手机");
    }
}
