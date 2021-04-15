package com.example.test.designpatterns.flyweight;

/**
 * @Author ： Leo
 * @Date : 2021/3/25 16:58
 * @Desc: 具体的网站
 */
public class ConcreteWebSite extends WebSite {

    // 网站发布的形式（类型）
    private String type = "";

    public ConcreteWebSite(String type) {
        this.type = type;
    }

    @Override
    public void use(User user) {
        System.out.println("网络发布的形式为："+this.type+" 使用者是："+user.getName());
    }
}
