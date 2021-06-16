package com.example.test.iostream.intputandout;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * lianmengliang
 * <p>顺序：3
 * 2021-06-07 22:36
 * Desc: 演示字节输出流 程序 ---> 文件
 */
public class FileOutStreamDemo {
    public static void main(String[] args) {
        fileWrite();
    }


    /**
     * 写入文件
     */
    public static void fileWrite() {
        // 文件不存在则创建，但目录是必须实际存在的
        String filePath = "/Users/lianmengliang/Desktop/testIo/a.txt";
        FileOutputStream outputStream = null;

        try {
            // 一般默认就是覆盖 写入new FileOutputStream(filePath)
            // 追加写入：FileOutputStream(String name, boolean append)
            outputStream = new FileOutputStream(filePath,true);

            //有三种方式写入到文件中：
            // 1.单个字节写入outputStream.write('H');
            // 2.多个字节写入 （字符串写入）
            // 3.多个字节写入,可以按照要求写入，比如只写入前3个字节

            outputStream.write('H');
            String str = "hello,world?";
//            outputStream.write(str.getBytes());

            outputStream.write(str.getBytes(),0,5);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
