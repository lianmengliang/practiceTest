package com.example.test.designpatterns.status.orderprocessing;

/**
 * @Author ： Leo
 * @Date : 2021/4/14 18:35
 * @Desc:
 */
public interface State {

    /**
     * 电 审
     */
    void checkEvent(Context context);


    /**
     * 电审失败
     */
    void checkFailEvent(Context context);


    /**
     * 定价发布
     */
    void makePriceEvent(Context context);

    void acceptOrderEvent(Context context);


    /**
     * 无人接单失效
     */
    void notPeopleAcceptEvent(Context context);


    /**
     * 付 款
     */
    void payOrderEvent(Context context);


    /**
     * 接单有人支付失效
     */
    void orderFailureEvent(Context context);


    /**
     * 反 馈
     */
    void feedBackEvent(Context context);



    String getCurrentState();
}
