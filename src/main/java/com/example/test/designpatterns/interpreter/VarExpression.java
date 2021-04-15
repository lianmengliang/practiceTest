package com.example.test.designpatterns.interpreter;

import java.util.HashMap;

/**
 * @Author ： Leo
 * @Date : 2021/4/12 18:27
 * @Desc:  变量的解释器
 */
public class VarExpression extends Expression {

    /**
     * key=a, key=b,key=c
     */
    private String key;

    public VarExpression(String key) {
        this.key = key;
    }

    /**
     * var 就是{a=10,b=20}
     * 根据 变量名臣，返回对应值
     * @param var
     * @return
     */
    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return var.get(this.key);
    }
}
