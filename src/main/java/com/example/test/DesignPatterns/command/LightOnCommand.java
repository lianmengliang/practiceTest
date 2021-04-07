package com.example.test.DesignPatterns.command;

/**
 * @Author ： Leo
 * @Date : 2021/4/6 17:28
 * @Desc:
 */
public class LightOnCommand implements Command {


    // 聚合LightReceiver
    private LightReceiver light;

    /**
     * 构造器
     * @param light
     */
    public LightOnCommand(LightReceiver light) {
        this.light = light;
    }

    @Override
    public void execute() {
        // 调用接受者的方法
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
