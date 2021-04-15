package com.example.test.designpatterns.status.improve;

/**
 * @Author ： Leo
 * @Date : 2021/4/12 10:45
 * @Desc: 用于主方法测试
 *
 * 抽奖方法：
 * 1. 单个对象 多次抽奖，不判断积分
 * 2. 单个对象 多次抽奖，积分条件判断 （分为：1次中奖机会 和 多次中奖机会）
 * 3. 多个对象 多次抽奖，积分条件判断 HashMap<String,Long> String: 用户名, Integer:积分
 *
 *抽奖流程：
 *
 * 初始化：
 * NoRaffleState-->CanRaffleState
 *  -->抽中：1.DispenseState 领奖-->
 *          -->1.奖品还有-->发奖 -->NoRaffleState
 *          -->2.奖品没了-->提示奖品发完了-->DispenseOutState
 *  -->未抽中：2.NoRaffleState
 *
 *
 * CanRaffleState
 * DispenseOutState
 * DispenseState
 * NoRaffleState
 *
 * RaffleActivity
 *
 * State
 */
public class Client {
    public static void main(String[] args) {

        // 创建活动对象，奖品有1个
        RaffleActivity activity = new RaffleActivity(1,6000L);

        for (int i = 0; i < 30; i++) {
            System.out.println("---第"+(i+1)+"次抽奖---");
            // 参加抽奖，第一步点击扣除积分
            activity.debuctMark();
            // 第二步抽奖
            activity.raffle();

        }
    }
}
