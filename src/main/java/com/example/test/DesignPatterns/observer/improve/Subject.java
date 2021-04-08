package com.example.test.DesignPatterns.observer.improve;


/**
 * @Author ： Leo
 * @Date : 2021/4/8 18:20
 * @Desc:
 */
public interface Subject {
    public void registerObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObservers();
}
