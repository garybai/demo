package com.example.codedesigndemo.pattern.state;

/**
 * 发放奖品状态
 *
 * @author Gary
 * @date 2020/3/30 22:19
 **/
public class DispenseState extends State {

    /**
     * 初始化传入活动引用
     */
    RaffleActivity activity;

    public DispenseState(RaffleActivity activity) {
        this.activity = activity;
    }

    /**
     * 扣除积分，当前状态不能扣除积分
     *
     * @return void
     * @author: Gary
     * @date: 2020/3/30 22:02
     */
    @Override
    public void deductMoney() {
        System.out.println("当前状态不能扣除积分");
    }

    /**
     * 是否抽中奖品，当前状态已经抽完奖
     *
     * @return boolean
     * @author: Gary
     * @date: 2020/3/30 22:02
     */
    @Override
    public boolean raffle() {
        System.out.println("当前状态已经抽完奖");
        return false;
    }

    /**
     * 发放奖品
     *
     * @return void
     * @author: Gary
     * @date: 2020/3/30 22:02
     */
    @Override
    public void dispensePrize() {
        if (activity.getCount() > 0) {
            System.out.println("恭喜中奖了");
            activity.setState(activity.getNoRaffleState());
        } else {
            System.out.println("奖品已经发放完毕了。。。");
            activity.setState(activity.getDispenseOutState());
        }
    }
}
