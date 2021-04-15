package com.example.test.designpatterns.status.orderprocessing;

/**
 * @Author ： Leo
 * @Date : 2021/4/14 18:59
 * @Desc:
 */
public class NotPayState extends AbstractState {
    @Override
    public String getCurrentState() {
        return StateEnum.NOT_PAY.getValue();
    }

    @Override
    public void payOrderEvent(Context context) {
        context.setState(new PaidState());
    }

    @Override
    public void feedBackEvent(Context context) {
        context.setState(new FeedBackState());
    }

}
