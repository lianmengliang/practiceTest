package com.example.test.designpatterns.bulider.improve;

/**
 * @Author ： Leo
 * @Date : 2021/3/22 18:32
 * @Desc:  高楼建造过程
 */
public class HighBuilding extends HouseBuilder {
    @Override
    void bulidBasic() {
        System.out.println(" 高楼的打地基 100 米 ");
    }

    @Override
    void bulidWalls() {
        System.out.println(" 高楼的砌墙 20cm ");
    }

    @Override
    void roofed() {
        System.out.println(" 高楼的透明屋顶 ");
    }
}
