package com.example.codedesigndemo.pattern.state;

/**
 * 抽奖活动
 *
 * @author Gary
 * @date 2020/3/30 22:05
 **/
public class RaffleActivity {

    /**
     * 活动当前状态，是变化的
     */
    State state = null;

    /**
     * 奖品数量
     */
    int count = 0;

    // 四个属性表示四种状态
    State noRaffleState = new NoRaffleState(this);
    State canRaffleState = new CanRaffleState(this);
    State dispenseState = new DispenseState(this);
    State dispenseOutState = new DispenseOutState(this);

    /**
     * 初始化当前状态为NoRaffleState状态，即不能抽奖状态，初始化奖品数量
     * @param count:
     * @return
     * @author: Gary
     * @date: 2020/3/30 22:30
     */
    public RaffleActivity(int count){
        this.count = count;
        this.state = getNoRaffleState();
    }

    /**
     * 调用当前状态的扣除积分
     */
    public void deductMoney(){
        state.deductMoney();
    }

    /**
     * 调用当前状态的抽奖
     */
    public void raffle(){
        if (state.raffle()){
            state.dispensePrize();
        }
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    /**
     * 每领取一次奖品，count--
     * @return
     */
    public int getCount() {
        int curCount = count;
        count--;
        return curCount;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public State getNoRaffleState() {
        return noRaffleState;
    }

    public void setNoRaffleState(State noRaffleState) {
        this.noRaffleState = noRaffleState;
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

    public State getDispenseOutState() {
        return dispenseOutState;
    }

    public void setDispenseOutState(State dispenseOutState) {
        this.dispenseOutState = dispenseOutState;
    }
}
