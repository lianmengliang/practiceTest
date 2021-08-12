package com.example.test.designpatterns.status.improve2;

/**
 * @Author ： Leo
 * @Date : 2021/4/14 15:43
 * @Desc:
 */
public class RaffleActivity {

    /**
     * 标识活动当前的状态，是变化
     */
    State state = null;

    /**
     * 数量
     */
    int count = 0;

    /**
     * 用户积分
     */
    Long grade = 0L;


    /**
     * 四个属性，表示四种状态
     *
     * @return
     */

    State noRafflleState = new NoRaffleState(this);
    State canRaffleState = new CanRaffleState(this);

    State dispenseState = new DispenseState(this);
    State dispensOutState = new DispenseOutState(this);


    /**
     * 构造器
     * 1.初始化当前的状态为 noRafflleState(即不能抽奖)
     * 2. 初始化奖品的数量
     *
     * @param count
     */
    public RaffleActivity(int count, Long grade) {
        this.state = this.getNoRafflleState();
        this.count = count;
        this.grade = grade;
    }

    /**
     * 扣分，调用当前状态的deductMoney
     */
    public void debuctMark() {
        state.deductMoney();
    }

    /**
     * 抽奖
     *
     * @return
     */
    public void raffle() {
        // 如果当前的状态是抽奖成功
        if (state.raffle()) {
            // 领取奖品
            state.dispensePrize();
        }
    }

    /**
     * 这里需要注意，每领取一次奖品 count--
     *
     * @return
     */
    public int getCount() {
        int curCount = this.count;
        count--;
        return curCount;
    }

    /**
     * 这里需要注意，抽取一次奖品，扣除积分50
     *
     * @return
     */

    public boolean isConformToGrade() {
        if (this.grade > 50) {
            this.grade = grade - 50;
            return true;
        } else {
            return false;
        }
    }

    public Long getGrade() {
        return grade;
    }

    public void setGrade(Long grade) {
        this.grade = grade;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public State getNoRafflleState() {
        return noRafflleState;
    }

    public void setNoRafflleState(State noRafflleState) {
        this.noRafflleState = noRafflleState;
    }

    public State getCanRaffleState() {
        return canRaffleState;
    }

    public void setCanRaffleState(State canRaffleState) {
        this.canRaffleState = canRaffleState;
    }

    public State getDispenseState() {
        return dispenseState;
    }

    public void setDispenseState(State dispenseState) {
        this.dispenseState = dispenseState;
    }

    public State getDispensOutState() {
        return dispensOutState;
    }

    public void setDispensOutState(State dispensOutState) {
        this.dispensOutState = dispensOutState;
    }
}
