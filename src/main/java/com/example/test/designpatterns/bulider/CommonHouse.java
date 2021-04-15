package com.example.test.designpatterns.bulider;

/**
 * @Author ： Leo
 * @Date : 2021/3/22 17:54
 * @Desc:
 */
public class CommonHouse extends AbstractHouse {
    @Override
    void bulidBasic() {
        System.out.println("给普通房子打地基");
    }

    @Override
    void bulidWalls() {
        System.out.println("给普通房子砌墙");
    }

    @Override
    void roofed() {
        System.out.println("给普通房子封顶");
    }
}
