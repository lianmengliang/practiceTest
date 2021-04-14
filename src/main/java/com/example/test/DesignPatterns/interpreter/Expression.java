package com.example.test.DesignPatterns.interpreter;

import java.util.HashMap;

/**
 * @Author ： Leo
 * @Date : 2021/4/12 18:25
 * @Desc: 可以获取到变量的值
 */
public abstract class Expression {

    /**
     * a + b -c
     * 解释公式和数值
     * @param var
     * @return
     */
    public abstract int interpreter(HashMap<String, Integer> var);
}
