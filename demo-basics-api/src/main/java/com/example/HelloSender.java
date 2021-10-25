package com.example;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author ： leo
 * @Date :2020/2/25 12:20
 */
@Component
public class HelloSender {


    @Autowired
    private AmqpTemplate rabbitTemlate;

    public  void send() {
        String context = "hello" + new Date();
        System.out.println("Sender :" + context);

        this.rabbitTemlate.convertAndSend("hello", context);
    }

    public static void main(String[] args) {
     /*   HelloSender helloSender = new HelloSender();
        helloSender.send();*/

        System.out.println("修改了");
    }
}
