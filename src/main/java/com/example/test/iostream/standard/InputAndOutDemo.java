package com.example.test.iostream.standard;

import java.util.Scanner;

/**
 * @Author ： Leo
 * <p>顺序：11
 * @Date : 2021/6/9 18:14
 * @Desc: 标准输入 和 标准输出
 */
public class InputAndOutDemo {
    public static void main(String[] args) {
        // public final static InputStream in = null;
        // System.in 编译类型 InputStream
        // System.in 运行类型 BufferedInputStream
        // 表示的是标准输入 键盘
        System.out.println("in：" + System.in.getClass());


        // 解读
        // 1.public final static PrintStream out = null;
        // 2.编译类型 PrintStream
        // 3.运行类型 PrintStream
        // 4.表示标准输出 显示器
        System.out.println("out：" + System.out.getClass());
        System.out.println("hello。Leo怪兽");


        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        System.out.println("输入内容：" + next);

    }
}
