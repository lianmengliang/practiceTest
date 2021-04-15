package com.example.test.designpatterns.bridge;

/**
 * @Author ： Leo
 * @Date : 2021/3/24 15:47
 * @Desc:
 */
public abstract class Phone {

    private Brand brand;

    public Phone(Brand brand) {
        super();
        this.brand = brand;
    }

    protected void open() {
        brand.open();
    }

    protected void close() {
        brand.close();
    }

    protected void call() {
        brand.call();
    }
}
