package com.example.test.designpatterns.status.orderprocessing;

/**
 * @Author ： Leo
 * @Date : 2021/4/14 19:00
 * @Desc:
 */
public class PaidState extends AbstractState {
    @Override
    public void feedBackEvent(Context context) { context.setState(new FeedBackState());
    }


    @Override
    public String getCurrentState() {
        return StateEnum.PAID.getValue();
    }
}
