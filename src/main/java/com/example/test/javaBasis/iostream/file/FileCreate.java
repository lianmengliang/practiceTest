package com.example.test.javaBasis.iostream.file;

import java.io.File;
import java.io.IOException;

/**
 * lianmengliang
 * <p> 顺序：1
 * 2021-06-06 11:40
 * 文件的创建
 */
public class FileCreate {
    public static void main(String[] args) {
//        newFile3();
//        commonOperationsForFile();
//        directoryOperations1();

        file01();
    }

    private static void file01() {

        File file = new File("src/");
        String[] list = file.list();
        for (String s : list) {
            System.out.println(s.split("\\.")[0]);
        }
        System.out.println(file.isFile());
        System.out.println(file.exists());

    }


    /**
     * 创建文件的第一种方式
     */
    public static void newFile1() {
        File file = new File("/Users/lianmengliang/Desktop/testIo/news1.txt");
        createFile(file);
    }

    /**
     * 创建文件的第2种方式
     */
    public static void newFile2() {
        File file = new File("/Users/lianmengliang/Desktop/testIo/", "news2.txt");
        createFile(file);

    }

    /**
     * 创建文件的第3种方式
     */
    public static void newFile3() {
        File file = new File("/Users/lianmengliang/Desktop/testIo/");
        File file1 = new File(file, "news3.txt");
        createFile(file1);

    }

    /**
     * 创建一个文件
     *
     * @param file
     */
    public static void createFile(File file) {
        try {
            if (file.createNewFile()) {
                System.out.println("创建成功");
                return;
            } else {
                System.out.println("创建失败");
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 常见的文件操作
     */
    public static void commonOperationsForFile() {
        File file = new File("/Users/lianmengliang/Desktop/testIo/news.txt");

        //常见的方法，获取file对象的信息
        System.out.println("getName:" + file.getName());
        System.out.println("AbsolutePath:" + file.getAbsolutePath());
        try {
            System.out.println("CanonicalPath:" + file.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("父级目录：" + file.getParent());
        System.out.println("path:" + file.getPath());
        System.out.println("文件大小:" + file.length());
        System.out.println("文件是否存在:" + file.exists());
        System.out.println("是否是文件:" + file.isFile());

    }

    /**
     * 文件夹的操作： 创建和删除 （目录）
     */
    public static void directoryOperations() {
        String filePath = "/Users/lianmengliang/Desktop/testIo/demo2";
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除成功");
            }
        } else {
            System.out.println("该目录不存在");
        }
    }
    /**
     * 文件夹的操作： 创建  (一级或多级文件夹创建)
     */
    public static void directoryOperations1() {
        String directoryPath = "/Users/lianmengliang/Desktop/testIo/demo02/demo02";
        File file = new File(directoryPath);
        if (file.exists()) {
            System.out.println("该目录存在");
        } else {
            if (file.mkdirs()) {
                System.out.println("创建成功");
            } else {
                System.out.println("创建失败");
            }
        }
    }


}
