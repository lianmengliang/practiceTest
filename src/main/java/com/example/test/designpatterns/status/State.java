package com.example.test.designpatterns.status;

/**
 * @Author ： Leo
 * @Date : 2021/4/14 15:30
 * @Desc:
 */
public abstract class State {

    /**
     * // 扣除积分 - 50
     */
    public abstract void deductMoney();

    /**
     * // 是否抽中奖品
     */
    public abstract boolean raffle();

    /**
     * // 发放奖品
     */
    public abstract void dispensePrize();
}
