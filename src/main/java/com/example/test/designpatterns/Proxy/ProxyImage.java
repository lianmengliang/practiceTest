package com.example.test.designpatterns.Proxy;

/**
 * @Author ： Leo
 * @Date : 2021/3/15 15:43
 * @Desc:
 */
public class ProxyImage implements Image {

    private RealImage realImage;

    private String fileName;

    public ProxyImage (String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {

        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
