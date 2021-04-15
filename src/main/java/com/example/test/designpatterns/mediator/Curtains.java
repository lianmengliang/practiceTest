package com.example.test.designpatterns.mediator;

/**
 * @Author ： Leo
 * @Date : 2021/4/9 15:01
 * @Desc:
 */
public class Curtains extends Colleague {
    public Curtains(Mediator mediator, String name) {
        super(mediator, name);
        mediator.Register(name,this);
    }

    @Override
    void sendMessage(int stateChange) {
        this.getMediator().getMessage(stateChange,this.name);
    }

    public void UpCurtains() {
        System.out.println("I am holding Up Curtains!");
    }
}
