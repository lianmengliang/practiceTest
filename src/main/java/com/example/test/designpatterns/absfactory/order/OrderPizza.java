package com.example.test.designpatterns.absfactory.order;

import com.example.test.designpatterns.absfactory.pizza.Pizza2;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author ： Leo
 * @Date : 2021/3/22 11:54
 * @Desc:
 */
public class OrderPizza {

    /**
     * 1. 依赖接口 方式实现： 开发中常用的方式
     * @param factory
     */
    public void orderPizza(AbsFactory factory) {
        String orderType = StringUtils.EMPTY;
        Pizza2 pizza2 = null;
        int orderTime = 1; //输入错误次数
        do {
            orderType = getType();
            pizza2 = factory.createPizza(orderType);
            // 输出pizza
            if (pizza2 != null) {
                //输出 pizza 制作过程
                pizza2.prepare();
                pizza2.bake();
                pizza2.cut();
                pizza2.box();
                orderTime = 1;
                System.out.println("===============制作完毕,订购成功================\n");

            } else if (orderTime >= 3) {
                System.out.println("您已点餐错误三次，请退出重新选择");
                break;
            } else {
                orderTime++;
                System.out.println("请输入‘cheese’或‘pepper’");
            }

        } while (true);
    }


    //2. 构造器方式实现，没有接口方式代码简便
   /* private AbsFactory factory;

    public OrderPizza(AbsFactory factory){
        setFactory(factory);
    }
    public void setFactory(AbsFactory factory) {
        String orderType = StringUtils.EMPTY;
        Pizza2 pizza2 = null;
        this.factory = factory;

        int orderTime = 1; //输入错误次数
        do {
            orderType = getType();
            pizza2 = factory.createPizza(orderType);
            // 输出pizza
            if (pizza2 != null) {
                //输出 pizza 制作过程
                pizza2.prepare();
                pizza2.bake();
                pizza2.cut();
                pizza2.box();
                System.out.println("===============制作完毕,订购成功================\n");

            } else if (orderTime >= 3) {
                System.out.println("您已点餐错误三次，请退出重新选择");
                break;
            } else {
                orderTime++;
                System.out.println("请输入‘cheese’或‘pepper’");
            }

        } while (true);
    }
*/


    /**
     * 获取披萨类型
     *
     * @return
     */
    private String getType() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请输入pizza口味:‘cheese’或‘pepper’");
            String str = strin.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}

