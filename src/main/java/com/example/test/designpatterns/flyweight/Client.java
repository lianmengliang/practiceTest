package com.example.test.designpatterns.flyweight;

/**
 * @Author ： Leo
 * @Date : 2021/3/25 17:22
 * @Desc:
 */
public class Client {

    public static void main(String[] args) {

        WebSiteFactory webSiteFactory = new WebSiteFactory();

        WebSite webSite1 = webSiteFactory.getWebSiteCategory("新闻");
        WebSite webSite2 = webSiteFactory.getWebSiteCategory("博客");
        WebSite webSite3 = webSiteFactory.getWebSiteCategory("新闻");
        WebSite webSite4 = webSiteFactory.getWebSiteCategory("博客");

        webSite1.use(new User("tom"));
        webSite2.use(new User("Leo"));
        webSite3.use(new User("Kevin"));
        webSite4.use(new User("Alice"));

        System.out.println(webSiteFactory.getWebSiteCount());


    }
}
