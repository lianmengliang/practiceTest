package com.example.test.iostream.intput;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/**
 * lianmengliang
 * <p>
 * 2021-06-07 22:01
 * <p>
 * Desc: 演示字节输入流 文件 ---> 程序
 */
public class FileInputStreamDemo {
    public static void main(String[] args) {
        readFile02();
    }


    /**
     * 使用read()方法读取
     */
    public static void readFile01() {
        String filePath = "/Users/lianmengliang/Desktop/testIo/hello.txt";

        int readData = 0;
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(filePath);

            while ((readData = fileInputStream.read()) != -1) {
                System.out.print((char) readData);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * 使用 read(byte[] byte)
     */
    public static void readFile02() {
        String filePath = "/Users/lianmengliang/Desktop/testIo/hello.txt";

        // 字节数组
        byte[] buf = new byte[8];
        int readLen = 0;

        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(filePath);

            while ((readLen=fileInputStream.read(buf)) != -1) {
//                System.out.print(Arrays.toString(buf));
                System.out.print(new String(buf,0,readLen));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
