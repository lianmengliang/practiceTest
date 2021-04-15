package com.example.test.designpatterns.command;

/**
 * @Author ： Leo
 * @Date : 2021/4/6 17:28
 * @Desc:
 */
public interface Command {

    // 执行动作（操作）
    void execute();

    // 撤销动作
    void undo();
}
