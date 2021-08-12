package com.example.test.designpatterns.mediator;

/**
 * @Author ： Leo
 * @Date : 2021/4/9 12:04
 * @Desc:
 */
public class Client {
    public static void main(String[] args) {
        // 创建一个中介者对象
        Mediator mediator = new ConcreteMediator();

        // 创建Alarm并且加入到 ConcreteMediator对象的HashMap
        Alarm alarm = new Alarm(mediator, "alarm");

        //创建了 CoffeeMachine 对象，并且加入到	ConcreteMediator 对象的 HashMap
        CoffeeMachine coffeeMachine = new CoffeeMachine(mediator,
                "coffeeMachine");

        // 创建Curtain，并且加入到 ConcreteMediator对象的HashMap
        Curtains curtains = new Curtains(mediator, "curtains");

        TV tv = new TV(mediator, "TV");

        // 让闹钟发出消息
        alarm.sendAlarm(0);
        coffeeMachine.finishCoffee();
        alarm.sendAlarm(1);

    }
}
