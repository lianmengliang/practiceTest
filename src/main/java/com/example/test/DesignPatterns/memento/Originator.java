package com.example.test.DesignPatterns.memento;

/**
 * @Author ： Leo
 * @Date : 2021/4/12 10:46
 * @Desc:
 */
public class Originator {
    /**
     * 状态消息
     */
    private String state;

    /**
     * 编写一个方法，可以保存一个状态对象Memento
     *
     * @return Memento
     */
    public Memento saveStateMemento() {
        return new Memento(state);
    }

    /**
     * 通过备忘录对象，恢复状态
     * @param memento
     */
    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
