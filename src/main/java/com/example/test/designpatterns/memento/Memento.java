package com.example.test.designpatterns.memento;

/**
 * @Author ： Leo
 * @Date : 2021/4/12 10:47
 * @Desc:
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

