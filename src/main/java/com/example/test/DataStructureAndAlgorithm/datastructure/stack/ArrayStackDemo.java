package com.example.test.DataStructureAndAlgorithm.datastructure.stack;

import sun.awt.SunHints;

import java.util.Scanner;

/**
 * @Author ： Leo
 * @Date : 2021/5/14 17:13
 * @Desc: 数组模拟栈
 */
public class ArrayStackDemo {
    public static void main(String[] args) {

        ArrayStack stack = new ArrayStack(5);

        String key = "";
        // 控制是否退出菜单
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 表示添加数据到栈(入栈)");
            System.out.println("pop: 表示从栈取出数据(出栈)");
            System.out.println();
            System.out.println("请输入你的选择：");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.show();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数据是 %d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("程序退出~~~");
    }

}

/**
 * 定义一个ArrayStack
 */
class ArrayStack {

    private int maxSize;

    private int[] stack;

    private int top = -1;

    /**
     * 构造器
     * @param maxSize
     */
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    // 栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // 栈空
    public boolean isEmpty() {
        return top == -1;
    }

    // 进(入)栈
    public void push(int value){
        // 先判断是否满了
        if (isFull()){
            System.out.println("栈已满");
            return;
        }
        top++;
        stack[top] = value;
    }

    // 出栈 -pop ,将栈顶的数据返回
    public int pop(){
        // 先判断是否为空
        if (isEmpty()){
            // 抛异常
            throw new RuntimeException("栈空，没有数据");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历 栈
    public void show(){
        // 先判断是否为空
        if (isEmpty()){
            // 抛异常
            throw new RuntimeException("栈空，没有数据");
        }
        // 需要从栈顶开始显示数据
        for (int i =top; i>=0; i--){
            System.out.printf("stack[%d] = %d\n",i,stack[i]);
        }
    }


}
