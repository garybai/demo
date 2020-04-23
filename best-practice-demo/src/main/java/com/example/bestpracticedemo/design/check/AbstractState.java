package com.example.bestpracticedemo.design.check;

/**
 * 状态抽象类
 *
 * @author Gary
 * @date 2020/3/31 10:40
 **/
public abstract class AbstractState implements State {

    protected static final RuntimeException EXCEPTION = new RuntimeException("非法状态转换");

    /**
     * 一审通过事件，状态由一审待审到二审待审
     *
     * @param context
     */
    @Override
    public void firstCheckPassEvent(Context context) {
        throw EXCEPTION;
    }

    /**
     * 一审驳回事件，状态由一审待审到一审驳回
     *
     * @param context
     */
    @Override
    public void firstCheckRejectEvent(Context context) {
        throw EXCEPTION;
    }

    /**
     * 一审修改事件，状态由一审驳回到一审待审
     *
     * @param context
     */
    @Override
    public void firstCheckModifyEvent(Context context) {
        throw EXCEPTION;
    }

    /**
     * 二审通过事件，状态由二审待审到三审待审
     *
     * @param context
     */
    @Override
    public void secondCheckPassEvent(Context context) {
        throw EXCEPTION;
    }

    /**
     * 二审驳回事件，状态由二审待审到二审驳回
     *
     * @param context
     */
    @Override
    public void secondCheckRejectEvent(Context context) {
        throw EXCEPTION;
    }

    /**
     * 二审修改事件，状态由二审驳回到二审待审
     *
     * @param context
     */
    @Override
    public void secondCheckModifyEvent(Context context) {
        throw EXCEPTION;
    }

    /**
     * 三审通过事件，状态由三审待审到可分发
     *
     * @param context
     */
    @Override
    public void thirdCheckPassEvent(Context context) {
        throw EXCEPTION;
    }

    /**
     * 三审驳回事件，状态由三审待审到三审驳回
     *
     * @param context
     */
    @Override
    public void thirdCheckRejectEvent(Context context) {
        throw EXCEPTION;
    }

    /**
     * 三审修改事件，状态由三审驳回到三审待审
     *
     * @param context
     */
    @Override
    public void thirdCheckModifyEvent(Context context) {
        throw EXCEPTION;
    }
}
