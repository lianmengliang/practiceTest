package com.example.test.javaBasis.iostream.intputandout;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author ： Leo
 * * <p>顺序：6
 * @Date : 2021/6/8 17:32
 * @Desc: 字符输出流  程序 --> 磁盘文件
 */
public class FileWriterDemo {
    public static void main(String[] args) throws IOException {
        fileWrite();
    }

    public static void fileWrite() throws IOException {
        String filePath = "G:\\testIO\\a.txt";
        FileWriter writer = new FileWriter(filePath);
        String targetStr = " 你好，IO流";
        char[] chars = new char[]{'L', 'O', 'V', 'E'};
        // 1.写入单个字符
        writer.write('H');
        // 2.写出指定数组
        writer.write(chars);
        // 3.写入指定数组的指定部分
        writer.write(chars, 0, 2);
        // 4.写入整个字符串
        writer.write(targetStr);
        // 5.写入字符串的指定部分
        writer.write(targetStr, 0, 6);
        if (writer != null) {
            //关闭文件流 close()等价于 flush() + 关闭
            // writer.flush();
            writer.close();
        }
    }
}
