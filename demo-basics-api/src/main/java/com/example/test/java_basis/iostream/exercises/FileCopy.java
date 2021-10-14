package com.example.test.java_basis.iostream.exercises;

import java.io.*;

/**
 * @Author ： Leo
 * <p>顺序：4
 * @Date : 2021/6/8 16:24
 * @Desc: 文件拷贝
 */
public class FileCopy {
    public static void main(String[] args) throws IOException {
        copyByReaderAndWriter();
    }


    /**
     * 完成文件拷贝， 将g盘的拷贝到c盘
     * G:\testIO  --> C:\
     */
    public static void copyFile() {
        // 1.先创建输入流，把磁盘文件拷贝到程序
        // 2.再创建输出流，把文件拷贝到磁盘

        /*String filePath = "G:\\testIO\\6.jpg";
        String targetPath = "C:\\6.jpg";*/

        String filePath = "G:\\testIO\\invitation.mp3";
        String targetPath = "E:\\invitation.mp3";


        // 1.创建输入流
        FileInputStream fis = null;
        // 2.再创建输出流
        FileOutputStream fos = null;

        try {

            fis = new FileInputStream(filePath);
            fos = new FileOutputStream(targetPath);

            byte[] bytes = new byte[1024];
            int readLen = 0;
            while ((fis.read(bytes)) != -1) {
                fos.write(bytes);
//                fos.write(bytes, 0, readLen);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                fos.close();
                System.out.println("拷贝成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * 完成文件拷贝， 将g盘的拷贝到c盘
     * G:\testIO  --> C:\
     * <p>
     * 代码完善
     */
    public static void copyFile1() {
        String filePath = "G:\\testIO\\invitation.mp3";
        String targetPath = "E:\\invitation.mp3";
        // 1.创建输入流
        FileInputStream fis = null;
        // 2.再创建输出流
        FileOutputStream fos = null;
        //使用byte字节数组，提高速去效率
        byte[] bytes = new byte[1024];
        int readLen = 0;
        try {

            fis = new FileInputStream(filePath);
            fos = new FileOutputStream(targetPath);
            while ((readLen = fis.read(bytes)) != -1) {
                // 读取文件后，就写写进去 （边读边写）
                // 一定要使用下面这个方法，便于读取文件完整 如：1039字节-- 添加1024字节
                fos.write(bytes, 0, readLen);
            }
            System.out.println("拷贝成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 使用FileReader 和 FileWriter进行文件的拷贝
     */
    public static void copyByReaderAndWriter() throws IOException {
        String srcFilePath = "G:\\testIO\\story.txt";
        String descFilePath = "E:\\666.txt";

        FileReader reader = new FileReader(srcFilePath);
        FileWriter writer = new FileWriter(descFilePath);

        char[] buff = new char[8];
        int readLen = 0;
        while((readLen = reader.read(buff))!=-1){
            writer.write(buff,0,readLen);
        }

        // 先关读，再关写
        reader.close();
        writer.close();

    }
}
