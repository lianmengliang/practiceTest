package com.example.test.designpatterns.simplefactory.order;


import com.example.test.designpatterns.simplefactory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author ： Leo
 * @Date : 2021/3/18 17:03
 * @Desc:
 */
public class OrderPizza {

    //构造器
   /* public OrderPizza() {
        Pizza pizza = null;
        String orderType; //  订购披萨的类型
        do {
            orderType = getType();
            if (orderType.equals("greek")) {
                pizza = new GreekPizza();
                pizza.setName(" 希腊披萨 ");
            } else if (orderType.equals("cheese")) {
                pizza = new CheesePizza();
                pizza.setName(" 奶酪披萨 ");
            } else if (orderType.equals("pepper")) {
                pizza = new PepperPizza();
                pizza.setName("胡椒披萨");
            } else {
                break;
            }
            //输出 pizza 制作过程
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
            System.out.println("===============制作完毕================");

        } while (true);
    }

*/
    // 定义一个简单工厂对象
    //定义一个简单工厂对象
    SimplePizzaFactory simpleFactory;
    Pizza pizza = null;

    //构造器
    public OrderPizza(SimplePizzaFactory simpleFactory) {
        setFactory(simpleFactory);
    }

    public void setFactory(SimplePizzaFactory simpleFactory) {
        String orderType = ""; //用户输入的
        this.simpleFactory = simpleFactory; //设置简单工厂对象

        do {
            orderType = getType();
//            pizza = this.simpleFactory.createPizza(orderType);
              pizza = SimplePizzaFactory.createPizza(orderType);

            // 输出pizza
            if (pizza != null) {
                //输出 pizza 制作过程
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
                System.out.println("===============制作完毕,订购成功================\n");

            } else {
                System.out.println("订购披萨失败。。。");
                break;
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
            System.out.println("请输入种类:");
            String str = strin.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}