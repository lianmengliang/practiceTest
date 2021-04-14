package com.example.test.DesignPatterns.memento.improve;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ： Leo
 * @Date : 2021/4/12 10:46
 * @Desc:
 */
public class Caretaker {

    /**
     * 保存一次状态 (单个角色，单个状态)
     */
    private Memento memento;
    /**
     * // 对GameRole保存多次状态(单个角色，多个状态)
     */
    private List<Memento> mementoList;

    /**
     * // 对多个游戏角色保存单个状态(多个角色，单个状态)
     */
    private Map<String, Memento> mementoMap = new HashMap<>();

    /**
     * // 对多个游戏角色保存多个状态(多个角色，多个状态)
     */
    private Map<String, List<Memento>> rolesMap;


    public List<Memento> getMementoList() {
        return mementoList;
    }

    public void setMementoList(List<Memento> mementoList) {
        this.mementoList = mementoList;
    }


    /**
     * 通过索引获取Originator的 备忘录对象（即保存状态）
     *
     * @param index
     * @return
     */
    public Memento getMementoByIndex(int index) {
        return mementoList.get(index);
    }

    /**
     * 添加方法
     *
     * @param memento
     */
    public void add(Memento memento) {
        mementoList.add(memento);
    }

    /**
     * 展示当前的进度
     */
    public void displayMementoByList() {
        if (!this.mementoList.isEmpty()) {
            for (Memento m : mementoList) {
                System.out.println(m.getDef() + "---" + m.getVit());
            }
//            mementoList.forEach(System.out::println);

        } else {
            System.out.println("当前角色没有储存的进度");
        }

    }

    /**
     * 展示角色
     */
    public void displayMementoByMap() {

        mementoMap.forEach((k, v) -> System.out.println(k + ":" + v.getVit() + "--" + v.getDef()));

       /* for (String str : mementoMap.keySet()){
            System.out.println(str+"-"+mementoMap.get(str));
        }*/
    }


    /**
     * 添加方法
     *
     * @param memento
     */
    public void addProgresstoMap(String progressName, Memento memento) {
        if (mementoMap.containsKey(progressName)) {

        } else {
            mementoMap.put(progressName, memento);

        }

    }

    /**
     * 通过存储名称获取Originator的 备忘录对象（即保存状态）
     *
     * @param progressName
     * @return
     */
    public Memento getMementoByName(String progressName) {
        return mementoMap.get(progressName);
    }


    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }


}
