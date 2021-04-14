package com.example.test.DesignPatterns.memento;

/**
 * @Author ： Leo
 * @Date : 2021/4/12 10:45
 * @Desc: 用于主方法测试
 */
public class Client {
    public static void main(String[] args) {

        Originator originator = new Originator();

        Caretaker caretaker = new Caretaker();

        originator.setState("状态#1 攻击力：100");
        // 保存当前的状态
        caretaker.add(originator.saveStateMemento());

        originator.setState("状态#2 攻击力: 180");
        caretaker.add(originator.saveStateMemento());

        originator.setState("状态#3 攻击力520");
        caretaker.add(originator.saveStateMemento());

        System.out.println("当前的状态是：" + originator.getState());



        Memento memento = caretaker.getMementoByIndex(0);
        System.out.println("状态1:" + memento.getState());

        originator.getStateFromMemento(caretaker.getMementoByIndex(1));
        //    // 希望恢复到状态2
        System.out.println("当前的状态是：" + originator.getState());
    }
}
