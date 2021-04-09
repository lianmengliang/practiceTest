package com.example.test.DesignPatterns.mediator;

/**
 * @Author ： Leo
 * @Date : 2021/4/9 11:47
 * @Desc:
 */
public class TV extends Colleague {

    public TV(Mediator mediator, String name) {
        super(mediator, name);

        mediator.Register(name, this);
    }

    @Override
    void sendMessage(int stateChange) {
        this.getMediator().getMessage(stateChange, this.name);
    }

    public void stopTV(){
        System.out.println("TV is stop");
    }

    public void startTV(){
        System.out.println("TV is start");
    }

}
