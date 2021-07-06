package com.example.test.javaBasis.network_programming;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author ： Leo
 * @Date : 2021/7/5 17:49
 * @Desc:
 */
public class inter_demo {
    public static void main(String[] args) throws UnknownHostException {


        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
    }
}
