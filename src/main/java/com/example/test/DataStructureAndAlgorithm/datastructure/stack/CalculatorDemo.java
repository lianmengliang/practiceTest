package com.example.test.DataStructureAndAlgorithm.datastructure.stack;

/**
 * @Author ： Leo
 * @Date : 2021/5/26 18:30
 * @Desc: 使用栈模拟计算器的功能
 */
public class CalculatorDemo {
    public static void main(String[] args) {

    }
}


/**
 * 自定义一个栈
 */
class CalcStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    /**
     * 构造器
     *
     * @param maxSize
     */
    public CalcStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    /**
     * 增加一个方法，可以返回当前栈顶的值，但是不是真正的pop
     *
     * @return
     */
    public int peek() {
        return stack[top];
    }

    /**
     * 判断是否栈满
     *
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 判断是否 栈空
     *
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈
     *
     * @param value
     */
    public void push(int value) {
        // 判断是否栈满
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    /**
     * 出栈 -pop ,将栈顶的数据返回
     */
    public int pop() {
        // 判断是否为空
        if (isEmpty()) {
            throw new RuntimeException("栈空,没有数据");
        }
        int value = stack[top];
        /*// 需要从栈顶显示数据
        for (int i =top; i >=0; i--){
            System.out.printf("stack[%d] = %d\n",i,stack[i]);
        }*/
        top--;
        return value;
    }

    /**
     * 显示栈的情况-遍历栈， 从栈顶开始遍历
     */
    public void list() {
        // 判断是否为空
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    /**
     * 返回运算符的优先级，优先级是程序员来确定, 优先级使用数字表示
     * 数字越大。则优先级越高
     *
     * @param oper
     * @return
     */
    public int priority(int oper) {
        // 假定目前的表达式只有 +, - , * , /
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 判断是不是一个运算符
     *
     * @param val
     * @return
     */
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    /**
     * 计算方法
     *
     * @param num1
     * @param num2
     * @param oper
     * @return
     */
    public int cal(int num1, int num2, int oper) {
        // res 用于存放计算的结果
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num1 - num2;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num1 / num2;
                break;
            default:
                break;
        }
        return res;
    }
}