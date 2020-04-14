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

//        String accessKeyId = "LTAI4FfhFy4UYs4GxK5cQVGY";
        String accessKeyId = "LTAIdmst7udCr3vB";

//        String accessKeySecret = "6iLCIoOnQHD4NOpcz3JGMLSLIzYZp5";
        String accessKeySecret = "Q8Yje9xS4z4Z2BTUhuPaT1bxz8qiDK";

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
