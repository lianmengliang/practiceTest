package com.example.test.designpatterns.status.orderprocessing;

/**
 * @Author ： Leo
 * @Date : 2021/4/14 19:01
 * @Desc:
 */
public class ReviewState extends AbstractState {
    @Override
    public String getCurrentState() {
        return StateEnum.REVIEWED.getValue();
    }

    @Override
    public void makePriceEvent(Context context) { context.setState(new PublishState());
    }
}
