package com.example.test.DesignPatterns.interpreter;

import java.util.HashMap;

/**
 * @Author ： Leo
 * @Date : 2021/4/12 18:30
 * @Desc:
 */
public class AddExpression extends SymbolExpression {

    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }


    /**
     * 处理相加
     * var 仍然是 {a=10,b=20}..
     * 一会我们 debug  源码,就 ok
     *
     * @param var
     * @return
     */
    @Override
    public int interpreter(HashMap<String, Integer> var) {
        //super.left.interpreter(var) ： 返回 left 表达式对应的值 a = 10
        //super.right.interpreter(var): 返回 right 表达式对应值 b = 20
        return super.left.interpreter(var) + super.right.interpreter(var);
    }
}
