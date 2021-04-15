package com.example.test.designpatterns.mediator;

/**
 * @Author ： Leo
 * @Date : 2021/4/9 12:04
 * @Desc:
 */
public class CoffeeMachine extends Colleague {

    public CoffeeMachine(Mediator mediator, String name) {
        super(mediator, name);
        mediator.Register(name,this);
    }

    @Override
    void sendMessage(int stateChange) {
        this.getMediator().getMessage(stateChange,this.name);
    }

    public void startCoffee(){
        System.out.println("It's time to open coffeeMachine");
    }

    public void finishCoffee(){
        System.out.println("After 5 minutes！");
        System.out.println("Coffee is OK！");

        sendMessage(0);
    }
}
