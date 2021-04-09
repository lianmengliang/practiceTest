package com.example.test.DesignPatterns.mediator;

/**
 * @Author ： Leo
 * @Date : 2021/4/9 11:50
 * @Desc: 具体的同事类
 */
public class Alarm extends Colleague {

    /**
     * 构造器
     * @param mediator
     * @param name
     */
    public Alarm(Mediator mediator, String name) {
        super(mediator, name);

        // 在创建Alarm同事对象时，将自己放到ConcreteMediator对象中【集合】
        mediator.Register(name,this);

    }

    public void sendAlarm(int stateChange){
        sendMessage(stateChange);
    }

    @Override
    void sendMessage(int stateChange) {
        // 调用中介者对象的getMessage
        this.getMediator().getMessage(stateChange, this.name);
    }
}
