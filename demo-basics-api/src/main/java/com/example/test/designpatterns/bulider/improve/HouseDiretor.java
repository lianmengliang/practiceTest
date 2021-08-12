package com.example.test.designpatterns.bulider.improve;

/**
 * @Author ： Leo
 * @Date : 2021/3/22 18:36
 * @Desc: 建房指挥者  （包工头）
 */
public class HouseDiretor {

    HouseBuilder houseBuilder = null;

    // 构造器传入
    public HouseDiretor(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }


    //通过setter方式传入houseBuilder
    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    // 如何处理建造房子的流程，交给指挥者
    public House constructHouse(String baise, String wall, String roofed) {
        houseBuilder.bulidBasic();
        houseBuilder.bulidWalls();
        houseBuilder.roofed();
        return houseBuilder.buildHouse(baise, wall, roofed);
    }
}
