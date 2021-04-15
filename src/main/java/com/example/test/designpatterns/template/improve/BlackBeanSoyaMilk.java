package com.example.test.designpatterns.template.improve;

/**
 * @Author ： Leo
 * @Date : 2021/4/6 14:56
 * @Desc:
 */
public class BlackBeanSoyaMilk extends SoyaMilk {
    @Override
    void addCondiments() {
        System.out.println("第二步：加入上好的黑豆...");
    }
}
