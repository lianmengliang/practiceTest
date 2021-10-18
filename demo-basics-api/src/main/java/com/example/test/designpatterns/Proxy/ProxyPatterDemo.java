package com.example.test.designpatterns.Proxy;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author ： Leo
 * @Date : 2021/3/15 15:45
 * @Desc:
 */
public class ProxyPatterDemo {

    public static void main(String[] args) {

        Image image = new ProxyImage("hello.txt");

        //
        image.display();
        System.out.println("---------------");
        //
        image.display();

    }
}
