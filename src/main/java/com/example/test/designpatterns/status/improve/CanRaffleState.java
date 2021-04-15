package com.example.test.designpatterns.status.improve;

import java.util.Random;

/**
 * @Author ： Leo
 * @Date : 2021/4/14 15:43
 * @Desc: 可以抽奖状态
 */
public class CanRaffleState extends State {

    private RaffleActivity activity;

    public CanRaffleState(RaffleActivity activity) {
        this.activity = activity;
    }

    /**
     * // 中奖号码
     */
    private final int WIN_NUMBER = 8;


    /**
     * 已经扣除积分了，不能再扣
     */
    @Override
    public void deductMoney() {
        System.out.println("已经扣除50积分，当前的积分为：" + activity.getGrade());

    }

    /**
     * 可以抽奖，抽完奖后，根据实际情况，改成新的状态
     *
     * @return
     */
    @Override
    public boolean raffle() {
        System.out.println("正在抽奖，请稍等！");

        Random random = new Random();
        int num = random.nextInt(10);
        System.out.println("--抽出的号码为：" + num);

        // 10%的中奖机会
        if (num == WIN_NUMBER) {
            //改变活动状态为发放奖品 context
            activity.setState(activity.getDispenseState(),activity.getGrade());
            return true;
        } else {
            System.out.println("很遗憾没有抽中奖品");
            // 改变状态为不能抽奖
            activity.setState(activity.getNoRafflleState(),activity.getGrade());
            return false;
        }
    }

    /**
     * 不能发放奖品
     */
    @Override
    public void dispensePrize() {
        System.out.println("没中奖，不能发放奖品");
    }
}
