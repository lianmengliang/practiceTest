package com.example.test.designpatterns.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ： Leo
 * @Date : 2021/3/25 17:04
 * @Desc: 网站工厂类， 根据需要返回一个网站
 */
public class WebSiteFactory {

    // 集合 充当池的作用
    private Map<String,ConcreteWebSite> pool = new HashMap<>();

    /**
     * 根据网站的类型，返回一个网站，
     * 如果没有就创建一个网站，放入到池中，并返回
     * @param type
     * @return
     */
    public WebSite getWebSiteCategory(String type){
        if (!pool.containsKey(type)){
            // 如果不存在，就创建一个网站放入池中
            pool.put(type,new ConcreteWebSite(type));
        }
        return (WebSite)pool.get(type);
    }

    /**
     * 获取网站分类的总数（池中有多少个网站类型）
     * @return
     */
    public int getWebSiteCount(){
        return pool.size();
    }

}
