package com.example.codedesigndemo.pattern.state;

import java.util.Random;

/**
 * 可以抽奖状态
 *
 * @author Gary
 * @date 2020/3/30 22:13
 **/
public class CanRaffleState extends State {

    /**
     * 初始化传入活动引用
     */
    RaffleActivity activity;

    public CanRaffleState(RaffleActivity activity) {
        this.activity = activity;
    }

    /**
     * 扣除积分，当前状态已经扣除过积分了
     *
     * @return void
     * @author: Gary
     * @date: 2020/3/30 22:02
     */
    @Override
    public void deductMoney() {
        System.out.println("已经扣除过积分了噢！");
    }

    /**
     * 是否抽中奖品，抽奖的具体逻辑
     *
     * @return boolean
     * @author: Gary
     * @date: 2020/3/30 22:02
     */
    @Override
    public boolean raffle() {
        System.out.println("正常抽奖。。。");
        Random r = new Random();
        int num = r.nextInt(10);
        System.out.println(num);
        if (num == 0){
            System.out.println("恭喜你，中奖了！");
            activity.setState(activity.getDispenseState());
            return true;
        } else {
            System.out.println("很遗憾，没有中奖！");
            activity.setState(activity.getNoRaffleState());
            return false;
        }
    }

    /**
     * 发放奖品，当前状态不能发奖
     *
     * @return void
     * @author: Gary
     * @date: 2020/3/30 22:02
     */
    @Override
    public void dispensePrize() {
        System.out.println("当前状态不能发放奖品");
    }
}
