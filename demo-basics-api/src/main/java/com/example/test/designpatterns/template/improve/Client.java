package com.example.test.designpatterns.template.improve;

/**
 * @Author ： Leo
 * @Date : 2021/4/6 15:00
 * @Desc:
 */
public class Client {
    public static void main(String[] args) {


        // 制作黑豆豆浆
        System.out.println("---制作黑豆豆浆---");
        SoyaMilk blackBeanSoyaMilk = new BlackBeanSoyaMilk();
        blackBeanSoyaMilk.make();

        // 制作花生豆浆
        System.out.println("--制作花生豆浆--");
        SoyaMilk pennutSoyaMilk = new PennutSoyaMilk();
        pennutSoyaMilk.make();

        // 制作纯豆浆
        System.out.println("--制作纯豆浆--");
        SoyaMilk prueSoyaMilk = new PrueSoyaMilk();
        prueSoyaMilk.make();

    }
}
