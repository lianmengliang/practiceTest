package com.example.test.javaBasis;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @Author ： Leo
 * @Date : 2021/4/12 10:45
 * @Desc: 用于主方法测试
 */
public class Client {
    public static void main(String[] args) {


//        Expression
//        ExpressionParser




    }

    /**
     * 测试源码的解释器
     */
    public void testExpressionParser(){
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("10 *(2+1)*1+66");
        int result = (int) expression.getValue();
        System.out.println(result);
    }

}
