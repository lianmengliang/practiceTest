package com.example.test.java_basis.iostream.intputandout;


import java.io.FileReader;
import java.io.IOException;

/**
 * @Author ： Leo
 * * <p>顺序：5
 * @Date : 2021/6/8 17:04
 * @Desc: 字符输入流： 文件 --> 程序
 */
public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
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
            while ((data = reader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
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
    public static void fileReader1() throws IOException {
        String filePath = "G:\\testIO\\story.txt";
        FileReader reader = new FileReader(filePath);
        int readLen = 0;
        // 使用char字符数组提高 读取效率
        char[] buf = new char[1024];
        //循环读取，使用read(buf)
        while ((readLen = reader.read(buf)) != -1) {
            System.out.print(new String(buf, 0, readLen));
        }

        if (reader != null) {
            reader.close();
        }
    }
}
