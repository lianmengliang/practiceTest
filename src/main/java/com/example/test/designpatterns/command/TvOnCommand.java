package com.example.test.designpatterns.command;

/**
 * @Author ： Leo
 * @Date : 2021/4/6 18:40
 * @Desc:
 */
public class TvOnCommand implements Command {
    private TVReceiver tvReceiver;

    public TvOnCommand(TVReceiver tvReceiver) {
        this.tvReceiver = tvReceiver;
    }

    @Override
    public void execute() {
        tvReceiver.on();
    }

    @Override
    public void undo() {
        tvReceiver.off();
    }
}
