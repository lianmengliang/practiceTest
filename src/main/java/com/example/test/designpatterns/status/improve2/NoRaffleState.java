package com.example.test.designpatterns.status.improve2;

/**
 * @Author ： Leo
 * @Date : 2021/4/14 15:43
 * @Desc: *不能抽奖状态
 */
public class NoRaffleState extends State {

    private RaffleActivity activity;

    public NoRaffleState(RaffleActivity activity) {
        this.activity = activity;
    }

    /**
     * 当前状态可以扣积分，扣除后，将状态设置成抽奖状态
     */
    @Override
    public void deductMoney() {
        if (activity.isConformToGrade()) {
            System.out.println("扣除50积分成功，目前剩余：" + activity.getGrade() + "积分---您可以抽奖了");
            // 改为抽奖状态
            activity.setState(activity.getCanRaffleState());
        } else {
            System.out.println("当前积分" + activity.getGrade() + "不满足抽奖条件，请参与其他活动获取积分再来抽奖吧");
            System.exit(0);
        }

    }

    /**
     * 当前状态不可以抽奖
     *
     * @return
     */
    @Override
    public boolean raffle() {
        System.out.println("扣了积分才能抽奖喔！");
        return false;
    }

    /**
     * 当前状态不能发奖品
     */
    @Override
    public void dispensePrize() {
        System.out.println("不能发放奖品");
    }
}
