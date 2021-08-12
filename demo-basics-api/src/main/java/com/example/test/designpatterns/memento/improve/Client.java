package com.example.test.designpatterns.memento.improve;

import java.util.ArrayList;

/**
 * @Author ： Leo
 * @Date : 2021/4/12 10:45
 * @Desc: 用于主方法测试
 *
 * 设置一个对象： 1.攻击力，2.防御力
 * 设置保存的的名称： 使用HashMap存储，key即是要保存时的名称，value就是对象
 *
 * 使用List管理
 */
public class Client {
    public static void main(String[] args) {

        // 创建游戏角色
        GameRole gameRole = new GameRole();
        gameRole.setDef(100);
        gameRole.setVit(100);
        System.out.println("和 boss 大战前的状态");
        gameRole.display();

        Memento memento = gameRole.createMemento();
        // 保存当前进度
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(memento);

        System.out.println("和Boss大战之后");
        gameRole.setDef(50);
        gameRole.setVit(40);
        gameRole.display();


        System.out.println("恢复到大战boss之前的状态");

        gameRole.recoverGameRoleFromMemento(caretaker.getMemento());

        System.out.println("恢复后的状态");
        gameRole.display();
       /* Memento memento = new Memento(180, 100);
        gameRole.recoverGameRoleFromMemento(memento);
        caretaker.setMemento(memento);*/

       // 单个角色 多个状态
        ArrayList<Memento> list = new ArrayList<>();
        list.add(memento);
        Memento memento1 = new Memento(190, 200);
        list.add(memento1);
        // 存取多个游戏状态
        caretaker.setMementoList(list);
        caretaker.displayMementoByList();

        // 多个角色 单个状态
        caretaker.addProgresstoMap("leo",memento);
        caretaker.addProgresstoMap("kevin",memento1);
        caretaker.displayMementoByMap();
    }
}
