package com.example.codedesigndemo.pattern.state;

/**
 * 奖品发放完毕状态
 *
 * @author Gary
 * @date 2020/3/30 22:23
 **/
public class DispenseOutState extends State {

    /**
     * 初始化传入活动引用
     */
    RaffleActivity activity;

    public DispenseOutState(RaffleActivity activity) {
        this.activity = activity;
    }

    /**
     * 扣除积分
     *
     * @return void
     * @author: Gary
     * @date: 2020/3/30 22:02
     */
    @Override
    public void deductMoney() {
        System.out.println("奖品发放完毕了，活动结束");
    }

    /**
     * 是否抽中奖品
     *
     * @return boolean
     * @author: Gary
     * @date: 2020/3/30 22:02
     */
    @Override
    public boolean raffle() {
        System.out.println("奖品发放完毕了，活动结束");
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
        System.out.println("奖品发放完毕了，活动结束");
    }
}
