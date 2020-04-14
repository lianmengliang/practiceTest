package com.example.test;

import com.example.domain.Student;
import com.example.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.io.File;

/**
 * @Author ： leo
 * @Date :2020/3/16 10:09
 */
public class testJson {
    public static void main(String[] args) {
        String a = "hello xiqu";
        getJson();
    }


   static void getJson(){


       User user = new User();

       user.setId(1);
       user.setPassWord("123");
       user.setRealName("leo");
       user.setUserName("lml");


       ObjectMapper objectMapper = new ObjectMapper();


       Label message = new Label("hello,java");
       String text = message.getText();
       System.out.println(text);

       Font font = new Font("text",12,12);

       message.setFont(font);
       System.out.println(message);

    /*   System.out.println(json);

        Student student = objectMapper.readValue(json, Student.class);

        System.out.println(student);*/





    }
}
