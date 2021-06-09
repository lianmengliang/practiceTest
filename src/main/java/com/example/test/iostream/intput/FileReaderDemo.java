package com.example.test.iostream.intput;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author ： Leo
 * @Date : 2021/6/8 17:04
 * @Desc:  文件 --> 程序
 */
public class FileReaderDemo {
    public static void main(String[] args) {
        fileReader1();
    }

    /**
     * 单个字符读取
     */
    public static void fileReader() {
        String filePath = "G:\\testIO\\story.txt";
        FileReader reader = null;

        int data = 0;

        try {
            reader = new FileReader(filePath);
            //循环读取，使用read，单个字符读取
            while ((data = reader.read())!=-1){
                System.out.print((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 多个字符读取
     */
    public static void fileReader1() {
        String filePath = "G:\\testIO\\story.txt";
        FileReader reader = null;
        int readLen = 0;
        // 使用char字符数组提高 读取效率
        char[] buf = new char[8];
        try {
            reader = new FileReader(filePath);
            //循环读取，使用read(buf)
            while ((readLen = reader.read(buf))!=-1){
                System.out.print(new String(buf,0,readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
