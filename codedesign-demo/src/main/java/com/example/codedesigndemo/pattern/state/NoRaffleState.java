package com.example.codedesigndemo.pattern.state;

/**
 * 不能抽奖状态
 *
 * @author Gary
 * @date 2020/3/30 22:03
 **/
public class NoRaffleState extends State {

    /**
     * 初始化传入活动引用
     */
    RaffleActivity activity;

    public NoRaffleState(RaffleActivity activity) {
        this.activity = activity;
    }

    /**
     * 扣除积分，当前状态可以扣除积分，扣除后，将状态改为可抽奖
     *
     * @return void
     * @author: Gary
     * @date: 2020/3/30 22:02
     */
    @Override
    public void deductMoney() {
        System.out.println("扣除50积分成功");
        activity.setState(activity.getCanRaffleState());
    }

    /**
     * 是否抽中奖品，当前状态不能抽奖
     *
     * @return boolean
     * @author: Gary
     * @date: 2020/3/30 22:02
     */
    @Override
    public boolean raffle() {
        System.out.println("扣了积分才能抽奖噢！");
        return false;
    }

    /**
     * 发放奖品，当前状态不能发放奖品
     *
     * @return void
     * @author: Gary
     * @date: 2020/3/30 22:02
     */
    @Override
    public void dispensePrize() {
        System.out.println("不能发放奖品");
    }
}
