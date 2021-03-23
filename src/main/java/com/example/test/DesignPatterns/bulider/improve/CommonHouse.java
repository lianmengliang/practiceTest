package com.example.test.DesignPatterns.bulider.improve;

/**
 * @Author ： Leo
 * @Date : 2021/3/22 18:32
 * @Desc: 普通房子建造流程
 */
public class CommonHouse extends HouseBuilder {
    @Override
    void bulidBasic() {
        System.out.println(" 普通房子打地基 5 米 ");
    }

    @Override
    void bulidWalls() {
        System.out.println(" 普通房子砌墙 10cm ");
    }

    @Override
    void roofed() {
        System.out.println(" 普通房子橡胶封顶");
    }
}
