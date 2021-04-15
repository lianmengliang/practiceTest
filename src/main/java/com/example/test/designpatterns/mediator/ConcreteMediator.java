package com.example.test.designpatterns.mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ： Leo
 * @Date : 2021/4/9 12:09
 * @Desc:
 */
public class ConcreteMediator extends Mediator {
    /**
     * 集合，放入所有同事对象
     * @param colleagueName
     * @param colleague
     */
    private Map<String, Colleague> colleagueMap;

    private Map<String, String> interMap;

    /**
     * 构造器
     *
     */
    public ConcreteMediator() {
        this.colleagueMap = new HashMap<>();
        this.interMap = new HashMap<>();
    }

    @Override
    public void Register(String colleagueName, Colleague colleague) {

        colleagueMap.put(colleagueName, colleague);

        if (colleague instanceof Alarm) {
            interMap.put("Alarm", colleagueName);
        }else if(colleague instanceof CoffeeMachine){
            interMap.put("CoffeeMachine",colleagueName);
        }else if(colleague instanceof TV){
            interMap.put("TV",colleagueName);
        }else if (colleague instanceof Curtains){
            interMap.put("Curtains",colleagueName);
        }
    }

    /**
     * 具体中介者的核心方法
     * 1.根据得到消息，完成对应任务
     * 2.中介者在这个方法，协调各个具体的同事对象，完后任务。
     * @param stateChange
     * @param colleagueName
     */
    @Override
    public void getMessage(int stateChange, String colleagueName) {
        // 处理闹钟发出的消息
        if (colleagueMap.get(colleagueName)instanceof Alarm){
            if (stateChange==0){
                /*CoffeeMachine coffeeMachine = (CoffeeMachine) colleagueMap.get(interMap.get("CoffeeMachine"));
                coffeeMachine.startCoffee();*/
                ((CoffeeMachine)colleagueMap.get(interMap.get("CoffeeMachine"))).startCoffee();
                ((TV)colleagueMap.get(interMap.get("TV"))).startTV();

            }else if (stateChange == 1){
                ((TV)colleagueMap.get(interMap.get("TV"))).stopTV();
            }
        }else if (colleagueMap.get(colleagueName)instanceof CoffeeMachine){
            ((Curtains)colleagueMap.get(interMap.get("Curtains"))).UpCurtains();

        }else if (colleagueMap.get(colleagueName)instanceof TV){
            // 如果TV发现消息

        }else if(colleagueMap.get(colleagueName)instanceof Curtains){
            // 如果是以窗帘发出的消息，这里处理...

        }


    }

    @Override
    public void sendMessage() {

    }
}
