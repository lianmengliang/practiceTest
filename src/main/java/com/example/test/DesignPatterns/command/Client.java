package com.example.test.DesignPatterns.command;

/**
 * @Author ： Leo
 * @Date : 2021/4/6 17:17
 * @Desc:
 */
public class Client {
    public static void main(String[] args) {

        // 创建电灯的对象（接受者）
        LightReceiver lightReceiver = new LightReceiver();

        // 创建电灯相关开关命令
        LightOnCommand lightOnCommand = new LightOnCommand(lightReceiver);
        LightOffCommand lightOffCommand = new LightOffCommand(lightReceiver);

        // 需要一个遥控器
        RemoteController controller = new RemoteController();

        controller.setCommand(0,lightOnCommand,lightOffCommand);

        System.out.println("---按下电灯开的按钮---");
        controller.onButton(0);
        System.out.println("---按下电灯关的按钮---");
        controller.offButton(0);
        System.out.println("---按下电灯撤销的按钮---");
        controller.undoButton();

        System.out.println("遥控器控制电视的开关");

        // 构造一个接受者
        TVReceiver tvReceiver = new TVReceiver();
        TvOnCommand tvOnCommand = new TvOnCommand(tvReceiver);
        TvOffCommand tvOffCommand = new TvOffCommand(tvReceiver);
        controller.setCommand(0,tvOnCommand,tvOffCommand);

        controller.onButton(0);
        controller.offButton(0);
        controller.undoButton();
    }
}
