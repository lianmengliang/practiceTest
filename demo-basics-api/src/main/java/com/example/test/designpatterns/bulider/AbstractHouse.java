package com.example.test.designpatterns.bulider;

/**
 * @Author ： Leo
 * @Date : 2021/3/22 17:50
 * @Desc:
 */
public abstract class AbstractHouse {

    // 打地基
    abstract void bulidBasic();

    // 建房
    abstract void bulidWalls();
    // 封顶
    abstract void roofed();


    public void build() {
        bulidBasic();
        bulidWalls();
        roofed();
    }
}
