package com.example.test.DesignPatterns.jdksourcecode.command;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @Author ： Leo
 * @Date : 2021/4/7 11:29
 * @Desc:
 */
public class testCommand {
    public static void main(String[] args) {

//        JdbcTemplate
//        Arrays


    }


    public void testIterator(){
        List<String> list = new ArrayList<>();
        list.add("1231");
        list.add("hello");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
