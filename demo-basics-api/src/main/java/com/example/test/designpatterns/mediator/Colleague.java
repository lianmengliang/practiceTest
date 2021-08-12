package com.example.test.designpatterns.mediator;

/**
 * @Author ： Leo
 * @Date : 2021/4/9 11:44
 * @Desc:  同事抽象类
 */
public abstract class Colleague {

    private Mediator mediator;

    public String name;

    public Colleague(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    /**
     * 发送消息的抽象类
     * @param stateChange
     */
    abstract void sendMessage(int stateChange);

    public Mediator getMediator() {
        return this.mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
