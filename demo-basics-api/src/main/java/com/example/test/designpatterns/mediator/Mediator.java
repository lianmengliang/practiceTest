package com.example.test.designpatterns.mediator;

/**
 * @Author ： Leo
 * @Date : 2021/4/9 11:45
 * @Desc:
 */
public abstract class Mediator {

    /**
     * 将给中介者，加入到集合中
     * @param colleagueName
     * @param colleague
     */
    public abstract void Register(String colleagueName,Colleague colleague);

    /**
     * 接收消息，具体的同事对象发出
     * @param stateChange
     * @param colleagueName
     */
    public abstract void getMessage(int stateChange,String colleagueName);


    public abstract void sendMessage();

}
