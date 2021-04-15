package com.example.test.designpatterns.bulider.improve;


/**
 * @Author ： Leo
 * @Date : 2021/3/22 17:56
 * @Desc:  建房中心
 */
public class BuilderCllient {
    public static void main(String[] args) {


       // 盖普通房子
        CommonHouse commonHouse = new CommonHouse();
        // 准备创建房子的指挥者
        HouseDiretor houseDiretor = new HouseDiretor(commonHouse);
        // 指挥建造普通房子
        House house = houseDiretor.constructHouse("打地基 5 米","砌墙 10cm","橡胶封顶");
        System.out.println(house);


        System.out.println("-------------------");

        HighBuilding highBuilding = new HighBuilding();

        HouseDiretor houseDiretor1 = new HouseDiretor(highBuilding);

        House highHouse = houseDiretor1.constructHouse("打地基 100 米","砌墙 20cm","玻璃封顶");
        System.out.println(highHouse);


        StringBuilder hello = new StringBuilder("hello");
        hello.append("213123");

    }
}
