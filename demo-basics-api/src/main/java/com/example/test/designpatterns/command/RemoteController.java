package com.example.test.designpatterns.command;

/**
 * @Author ： Leo
 * @Date : 2021/4/6 17:59
 * @Desc:
 */
public class RemoteController {

    // 开 按钮的命令数组；
    private Command[] onCommands;

    private Command[] offCommands;

    // 执行撤销的命令
    private Command undoCommand;

    public RemoteController() {
        this.onCommands = new Command[5];
        this.offCommands = new Command[5];

        for (int i = 0; i < 5; i++) {
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
    }

    /**
     * 给我们的按钮设置你需要的命令
     *
     * @param no
     * @param onCommand
     * @param offCommand
     */
    public void setCommand(int no, Command onCommand, Command offCommand) {
        onCommands[no] = onCommand;
        offCommands[no] = offCommand;
    }


    /**
     * 打开按钮
     *
     * @param no
     */
    public void onButton(int no) {

        // 找到你按下开的按钮，并调用对应方法
        onCommands[no].execute();

        //记录这次的操作，用于撤销
        undoCommand = onCommands[no];
    }

    /**
     * 关闭 按钮
     *
     * @param no
     */
    public void offButton(int no) {
        // 找到你按下开的按钮，并调用对应方法
        offCommands[no].execute();

        //记录这次的操作，用于撤销
        undoCommand = offCommands[no];
    }

    /**
     * 撤销
     */
    public void undoButton() {
        undoCommand.undo();
    }
}
