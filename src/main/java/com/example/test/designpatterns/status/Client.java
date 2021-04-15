package com.example.test.designpatterns.status;

/**
 * @Author ： Leo
 * @Date : 2021/4/12 10:45
 * @Desc: 用于主方法测试
 */
public class Client {
    public static void main(String[] args) {

        // 创建活动对象，奖品有1个
        RaffleActivity activity = new RaffleActivity(1);

        for (int i = 0; i < 30; i++) {
            System.out.println("---第"+(i+1)+"次抽奖---");
            // 参加抽奖，第一步点击扣除积分
            activity.debuctMark();
            // 第二步抽奖
            activity.raffle();
        }

    }
}
