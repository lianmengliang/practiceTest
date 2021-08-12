package com.example.test;

import com.example.encryptionUtil.MD5Utils;
import com.example.utils.Md5Encrypt;

/**
 * @Author ： leo
 * @Date :2020/5/9 15:06
 */
public class testEncryption {


    public static void main(String[] args) {
        String string = "我是一句话";

        System.out.println(MD5Utils.byteArrayToHexString(string.getBytes()));

        System.out.println(Md5Encrypt.MD5(string));

    }

}
