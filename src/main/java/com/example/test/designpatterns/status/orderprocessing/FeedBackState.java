package com.example.test.designpatterns.status.orderprocessing;

/**
 * @Author ： Leo
 * @Date : 2021/4/14 18:57
 * @Desc: //各种具体状态类
 */
public class FeedBackState extends AbstractState {
    @Override
    public String getCurrentState() {
        return StateEnum.FEED_BACKED.getValue();
    }
}
