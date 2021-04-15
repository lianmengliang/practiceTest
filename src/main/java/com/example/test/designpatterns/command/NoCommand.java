package com.example.test.designpatterns.command;

/**
 * @Author ： Leo
 * @Date : 2021/4/6 17:52
 * @Desc: 没有任何命令，即空执行，用于初始化执行遥控器按钮，当调用空命令时，什么都不执行
 *          其实这也是一种设计模式，可以省掉对空的判断
 */
public class NoCommand implements Command{
    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
