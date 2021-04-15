package com.example.test.designpatterns.interpreter;

import java.util.HashMap;

/**
 * @Author ： Leo
 * @Date : 2021/4/13 11:58
 * @Desc:
 */
public class SubExpression extends SymbolExpression{


    public SubExpression(Expression left, Expression right) {
        super(left, right);
    }


    /**
     *     //求出 left 和 right  表达式相减后的结果
     * @param var
     * @return
     */
    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return super.left.interpreter(var) - super.right.interpreter(var);
    }
}
