package com.example.test.java_basis.iostream.print;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * @Author ： Leo
 * <p>顺序：13
 * @Date : 2021/6/10 16:34
 * @Desc:
 * PrintStream: 字节打印流|输出流
 *
 * PrintWriter: 字符打印流
 */
public class PrintDemo {
    public static void main(String[] args) throws IOException {


//        printFileByPrintStream();
        printFileByPrintWriter();
    }

    /***
     * 通过PrintWriter 字节打印流实现打印输出功能
     */
    private static void printFileByPrintWriter() throws IOException {
//        PrintWriter writer = new PrintWriter(System.out);

        PrintWriter writer = new PrintWriter(new FileWriter("G:\\testIO\\print.txt"));
        writer.println("hi，Leo你好");
        // 一定要关闭流,close()方法 里面才有写入数据的过程
        writer.close();
    }

    /***
     * 通过PrintStream 字节打印流实现打印输出功能
     * @throws IOException
     */
    private static void printFileByPrintStream() throws IOException {

        PrintStream out = System.out;
        // 在默认情况下，PrintStream输出数据的位置是 标准输出，即显示器
        out.print("hello,Leo");

        // 因为print底层使用的是write，所以我们可以直接调用write进行打印/输出
        // 源码：
        // public void print(String s) {
        //        if (s == null) {
        //            s = "null";
        //        }
        //        write(s);
        //    }
        out.write("hello,你好".getBytes());
        // 关闭
        out.close();



        //我们可以去修改打印流输出的位置/设备
        //1.输出修改成到 G:\testIO\s.txt
        //2."hello,Leo打怪兽~"就会输出到G:\testIO\a1.txt
        //3.源码
        // public static void setOut(PrintStream out) {
        //        checkIO();
        //        setOut0(out);
        //    }

        System.setOut(new PrintStream("G:\\testIO\\s.txt"));
        System.out.println("hello,Leo打怪兽~");
    }


}
