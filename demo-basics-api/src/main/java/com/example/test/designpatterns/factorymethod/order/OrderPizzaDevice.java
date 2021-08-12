package com.example.test.designpatterns.factorymethod.order;


import com.example.test.designpatterns.factorymethod.pizza.Pizza2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author ： Leo
 * @Date : 2021/3/18 17:03
 * @Desc:
 */
public abstract class OrderPizzaDevice {

    //定义一个抽象方法，createPizza，让各个工厂子类自己实现
    abstract Pizza2 createPizza(String orderType);


    public OrderPizzaDevice() {

        Pizza2 pizza2 = null;
        String orderType = ""; //用户输入的
        int orderTime = 1;        // 记录点餐次数
        do {
            orderType = getType();
            pizza2 = createPizza(orderType);
            // 输出pizza
            if (pizza2 != null) {
                //输出 pizza 制作过程
                pizza2.prepare();
                pizza2.bake();
                pizza2.cut();
                pizza2.box();
                System.out.println("===============制作完毕,订购成功================\n");

            } else if(orderTime>=3){
                System.out.println("您已点餐错误三次，请退出重新选择");
                break;
            }else {
                orderTime++;
                System.out.println("请输入‘cheese’或‘pepper’");
            }

        } while (true);
    }

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