package com.example.test.test_demo;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author ： Leo
 * @Date : 2021/10/14 11:36
 * @Desc:  用于临时测试 或 间接通过这里去学习源码
 */
public class TestDemo001  {
    public static void main(String[] args) {
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("10 *(2+1)*1+66");
        int result = (int) expression.getValue();
        System.out.println(result);
    }



}
class demo001 extends Observable {



}