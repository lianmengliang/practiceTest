package com.example.test.designpatterns.Proxy;

/**
 * @Author ： Leo
 * @Date : 2021/3/15 15:40
 * @Desc:
 */
public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFormDisk(fileName);
    }

    private void loadFormDisk(String fileName) {
        System.out.println("Loading:" + fileName);
    }

    @Override
    public void display() {
        System.out.println("Display:" + fileName);
    }
}
