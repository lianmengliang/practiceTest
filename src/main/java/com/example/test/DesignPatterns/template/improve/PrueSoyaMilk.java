package com.example.test.DesignPatterns.template.improve;



/**
 * @Author ： Leo
 * @Date : 2021/4/6 15:10
 * @Desc:
 */
public class PrueSoyaMilk extends SoyaMilk {
    @Override
    void addCondiments() {
        // 无须操作
        System.out.println("不加入任何配料");
    }

    @Override
    boolean customerWantCondiments(){
        return  false;
    }
}
