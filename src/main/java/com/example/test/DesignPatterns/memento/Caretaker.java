package com.example.test.DesignPatterns.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ： Leo
 * @Date : 2021/4/12 10:46
 * @Desc:
 */
public class Caretaker {
    /**
     * 在List集合中会有很多的备忘录对象
     */
    private List<Memento> mementoList = new ArrayList<>();

    /**
     * 添加方法
     * @param memento
     */
    public void add(Memento memento){
        mementoList.add(memento);
    }

    /**
     * 通过索引获取Originator的 备忘录对象（即保存状态）
     * @param index
     * @return
     */
    public Memento getMementoByIndex(int index){
        return mementoList.get(index);
    }

    

}
