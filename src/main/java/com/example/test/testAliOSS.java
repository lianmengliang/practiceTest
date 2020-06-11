package com.example.test;

import com.aliyun.oss.OSSClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @Author ： leo
 * @Date :2020/3/17 15:12
 */
public class testAliOSS {
    public static void main(String[] args) {


        String endpoint = "http://oss-cn-beijing.aliyuncs.com";

//        String accessKeyId = "\u004c\u0054\u0041\u0049\u0034\u0046\u0066\u0068\u0046\u0079\u0034\u0055\u0059\u0073\u0034\u0047\u0078\u004b\u0035\u0063\u0051\u0056\u0047\u0059";
        String accessKeyId = "";

//        String accessKeySecret = "\u0036\u0069\u004c\u0043\u0049\u006f\u004f\u006e\u0051\u0048\u0044\u0034\u004e\u004f\u0070\u0063\u007a\u0033\u004a\u0047\u004d\u004c\u0053\u004c\u0049\u007a\u0059\u005a\u0070\u0035";
        String accessKeySecret = "";

        String bucketName= "qing-cheng";
        //创建OSSClient 实例
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

        // 上传文件流
        InputStream inputStream = null;

        try {
             inputStream = new FileInputStream("C:/Users/xw/Desktop/allJava.jpg");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ossClient.putObject(bucketName,"allJava.jpg",inputStream);

        //关闭client
        ossClient.shutdown();
    }
}
