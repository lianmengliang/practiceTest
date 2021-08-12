package com.example.test.designpatterns.command;

/**
 * @Author ： Leo
 * @Date : 2021/4/6 17:50
 * @Desc:
 */
public class LightOffCommand implements Command {


    // 聚合LightReceiver
    private LightReceiver light;

    /**
     * 构造器
     * @param light
     */
    public LightOffCommand(LightReceiver light) {
        this.light = light;
    }

    @Override
    public void execute() {
        // 调用接受者的方法
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
