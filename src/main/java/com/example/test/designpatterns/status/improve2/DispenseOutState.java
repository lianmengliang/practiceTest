package com.example.test.designpatterns.status.improve2;

/**
 * @Author ： Leo
 * @Date : 2021/4/14 15:43
 * @Desc: 奖品发放完毕 状态
 */
public class DispenseOutState extends State {
    private RaffleActivity activity;

    public DispenseOutState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("奖品发送完了，请下次再参加");
        System.out.println("您目前的积分为："+activity.getGrade());
    }

    @Override
    public boolean raffle() {
        System.out.println("奖品发送完了，请下次再参加");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("奖品发送完了，请下次再参加");
    }
}
