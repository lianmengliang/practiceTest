package com.example.test.designpatterns.singleResponsibility;

/**
 * @Author ： Leo
 * @Date : 2021/3/16 16:41
 * @Desc:
 *
 * 单一职责原则注意事项和细节
 *
 * 1)降低类的复杂度，一个类只负责一项职责。
 * 2)提高类的可读性，可维护性
 * 3)降低变更引起的风险
 * 4)通常情况下，我们应当遵守单一职责原则，只有逻辑足够简单，才可以在代码级违反单一职责原则；只有类中方法数量足够少，可以在方法级别保持单一职责原则
 */
public class SingleResponsibility2 {
    public static void main(String[] args) {
        VehicleRoad road = new VehicleRoad();
        road.run("摩托车");
        road.run("汽车");

        VehicleAir air = new VehicleAir();
        air.runAir("飞机");

        VehicleWater water = new VehicleWater();
        water.runWater("帆船");
    }
}

class VehicleRoad {
    void run(String vehicle) {
        System.out.println(vehicle + "在公路上跑");
    }

}

class VehicleWater {
    void runWater(String vehicle) {
        System.out.println(vehicle + "在公路上跑");
    }

}

class VehicleAir {
    void runAir(String vehicle) {
        System.out.println(vehicle + "在天上飞");
    }

}
