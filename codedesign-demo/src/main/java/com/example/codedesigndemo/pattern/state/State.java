package com.example.codedesigndemo.pattern.state;

/**
 * 状态抽象类
 *
 * @author Gary
 * @date 2020/3/30 22:01
 **/
public abstract class State {

    /**
     * 扣除积分
     * @param : 
     * @return void
     * @author: Gary
     * @date: 2020/3/30 22:02
     */
    public abstract void deductMoney();

    /**
     * 是否抽中奖品
     * @param :
     * @return boolean
     * @author: Gary
     * @date: 2020/3/30 22:02
     */
    public abstract boolean raffle();

    /**
     * 发放奖品
     * @param :
     * @return void
     * @author: Gary
     * @date: 2020/3/30 22:02
     */
    public abstract void dispensePrize();

}
