package com.example.test.DesignPatterns.singleResponsibility;

/**
 * @Author ： Leo
 * @Date : 2021/3/16 16:41
 * @Desc: 单一职责原则注意事项和细节
 * <p>
 * 1)降低类的复杂度，一个类只负责一项职责。
 * 2)提高类的可读性，可维护性
 * 3)降低变更引起的风险
 * 4)通常情况下，我们应当遵守单一职责原则，只有逻辑足够简单，才可以在代码级违反单一职责原则；只有类中方法数量足够少，可以在方法级别保持单一职责原则
 */
public class SingleResponsibility1 {
    public static void main(String[] args) {
        Vehicle2 vehicle = new Vehicle2();
        vehicle.run("摩托车");
        vehicle.run("汽车");
        vehicle.runAir("飞机");
        vehicle.runWater("帆船");
    }
}


/**
 * 1. 这种修改方法没有对原来的类做大的修改，只是增加方法
 * 2. 这里虽然没有在类这个级别上遵守单一职责原则，但是在方法级别上，仍然是遵守单一职责
 */
class Vehicle2 {
    public void run(String vehicle) {

        System.out.println(vehicle + " 在公路上运行....");


    }

    public void runAir(String vehicle) {
        System.out.println(vehicle + " 在天空上运行....");
    }


    public void runWater(String vehicle) {
        System.out.println(vehicle + " 在水中行....");
    }

}
