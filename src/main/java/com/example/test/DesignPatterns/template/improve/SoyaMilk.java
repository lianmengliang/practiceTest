package com.example.test.DesignPatterns.template.improve;

/**
 * @Author ： Leo
 * @Date : 2021/4/6 14:49
 * @Desc:
 */
public abstract class SoyaMilk {

    // 制作过程
    final void make() {
        select();
        if (customerWantCondiments()){
            addCondiments();
        }
        soak();
        beat();
    }

    /**
     * 选材
     */
    void select() {
        System.out.println("第一步：选择好的新鲜黄豆..");
    }

    //添加不同的配料， 抽象方法,  子类具体实现
    abstract void addCondiments();


    // 浸泡
    void soak() {
        System.out.println("第三步：浸泡黄豆和配料3小时");
    }

    // 打浆过程
    void beat() {
        System.out.println("第四步：把黄豆和配料放到豆浆机中打浆");
    }

    // 钩子方法，决定是否需要添加配料
    boolean customerWantCondiments(){
        return true;
    }
}
