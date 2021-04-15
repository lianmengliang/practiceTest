package com.example.test.designpatterns.status.orderprocessing;

/**
 * @Author ： Leo
 * @Date : 2021/4/14 18:58
 * @Desc:
 */
public class GenerateState extends AbstractState {

    @Override
    public void checkEvent(Context context) { context.setState(new ReviewState());
    }


    @Override
    public void checkFailEvent(Context context) { context.setState(new FeedBackState());
    }


    @Override
    public String getCurrentState() {
        return StateEnum.GENERATE.getValue();
    }
}
