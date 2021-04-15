package com.example.test.designpatterns.bulider.improve;

/**
 * @Author ： Leo
 * @Date : 2021/3/22 18:27
 * @Desc: 房子建造者 （建筑工人）
 */
public abstract class HouseBuilder {

    protected House house = new House();

    // 将建造的流程写好，抽象方法
    // 打地基
    abstract void bulidBasic();

    // 建房
    abstract void bulidWalls();

    // 封顶
    abstract void roofed();

    // 建造房子后，讲产品房子返回
    public House buildHouse(String baise, String wall, String roofed) {
        house.setBaise(baise);
        house.setWall(wall);
        house.setRoofed(roofed);
        return house;
    }
}
