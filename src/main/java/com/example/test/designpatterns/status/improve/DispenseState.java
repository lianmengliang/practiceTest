package com.example.test.designpatterns.status.improve;

/**
 * @Author ： Leo
 * @Date : 2021/4/14 15:43
 * @Desc: 发放奖品的状态
 */
public class DispenseState extends State {

    private RaffleActivity activity;

    public DispenseState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("不能扣除积分");
    }

    @Override
    public boolean raffle() {
        System.out.println("不能抽奖");
        return false;
    }

    /**
     * 发放奖品
     */
    @Override
    public void dispensePrize() {
        if (activity.getCount() > 0) {
            System.out.println("恭喜您中奖了");
            // 改变状态为不能抽奖
            activity.setState(activity.getNoRafflleState(), activity.getGrade());
        } else {
            System.out.println("很遗憾，奖品发送完了");

            System.out.println("您目前剩余：" + activity.grade + "积分");
            // 改变状态为奖品发送完毕，后面我们就不可以抽奖了
             activity.setState(activity.getDispensOutState(),activity.getGrade());

            System.out.println("抽奖活动结束");
            System.exit(0);
        }


    }
}
