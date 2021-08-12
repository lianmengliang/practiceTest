package com.example.test.designpatterns.observer.improve;

/**
 * @Author ： Leo
 * @Date : 2021/4/8 18:27
 * @Desc: 观察者接口，由观察者来实现
 */
public interface Observer {

    public void update(float temperature, float pressure, float humidity);


}
