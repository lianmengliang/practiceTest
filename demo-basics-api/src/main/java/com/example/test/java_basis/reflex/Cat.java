package com.example.test.java_basis.reflex;

/**
 * @Author ： Leo
 * @Date : 2021/6/16 18:49
 * @Desc:
 */
public class Cat {
    public String name = "招财猫";

    public String color = "白色";

    private Cat(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }

    public void hi() {
//        System.out.println("Hi,招财猫");
    }

    public void cry() {
        System.out.println("招财猫在喵喵叫~~");
    }


    private static String say(int a, String s) {
        return a + s + "-----";
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
