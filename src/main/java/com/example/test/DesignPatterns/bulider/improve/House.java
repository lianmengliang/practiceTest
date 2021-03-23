package com.example.test.DesignPatterns.bulider.improve;

/**
 * @Author ： Leo
 * @Date : 2021/3/22 18:26
 * @Desc:  房子类 （概括所有的房子类型）
 */
public class House {
    private String baise;

    private String wall;

    private String roofed;

    @Override
    public String toString() {
        return "House{" +
                "baise='" + baise + '\'' +
                ", wall='" + wall + '\'' +
                ", roofed='" + roofed + '\'' +
                '}';
    }

    public String getBaise() {
        return baise;
    }

    public void setBaise(String baise) {
        this.baise = baise;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getRoofed() {
        return roofed;
    }

    public void setRoofed(String roofed) {
        this.roofed = roofed;
    }
}
