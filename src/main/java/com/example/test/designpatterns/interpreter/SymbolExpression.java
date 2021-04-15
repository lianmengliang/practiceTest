package com.example.test.designpatterns.interpreter;

import java.util.HashMap;

/**
 * @Author ： Leo
 * @Date : 2021/4/12 18:28
 * @Desc:
 *      抽象运算符号解析器 这里，每个运算符号，都只和自己左右两个数字有关系
 *      但左右两个数字有可能也是一个解析的结果，无论何种类型，都是Expression的子类
 */
public class SymbolExpression extends Expression {

    protected Expression left;
    protected Expression right;

    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * /因为 SymbolExpression  是让其子类来实现，因此 interpreter 是一个默认实现
     * @param var
     * @return
     */
    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return 0;
    }
}
