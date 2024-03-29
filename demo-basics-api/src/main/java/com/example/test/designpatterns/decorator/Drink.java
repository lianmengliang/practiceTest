package com.example.test.designpatterns.decorator;

/**
 * @Author ： Leo
 * @Date : 2021/3/24 17:52
 * @Desc:
 */
public abstract class Drink {

    // 描述
    public String des;

    private float price = 0.0f;


    // 计算费用的抽象方法 (子类来实现)
    public abstract float cost();

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public float getPrice() {
//        System.out.println("DrinkClassPrint----> des：" + des + "\t price：" + price);
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
