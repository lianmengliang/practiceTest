package com.example.test.javaBasis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Comparator;
import java.util.Observable;
import java.util.Observer;

/**
 * @Author ： Leo
 * @Date : 2021/4/12 10:45
 * @Desc: 用于主方法测试
 */
public class Client {
    public static void main(String[] args) {
//        Observer
//        ApplicationEvent
//        ApplicationContext
//        AbstractApplicationContext


//        Resource
//        JdbcTemplate

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        };


    }

}
