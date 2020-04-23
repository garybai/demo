package com.example.bestpracticedemo.design.check;

/**
 * 审核上下文，保存当前的状态
 *
 * @author Gary
 * @date 2020/3/31 10:45
 **/
public class Context extends AbstractState {

    private State state;

    /**
     * 一审通过事件，状态由一审待审到二审待审
     *
     * @param context
     */
    @Override
    public void firstCheckPassEvent(Context context) {
        state.firstCheckPassEvent(this);
    }

    /**
     * 一审驳回事件，状态由一审待审到一审驳回
     *
     * @param context
     */
    @Override
    public void firstCheckRejectEvent(Context context) {
        state.firstCheckRejectEvent(this);
    }

    /**
     * 一审修改事件，状态由一审驳回到一审待审
     *
     * @param context
     */
    @Override
    public void firstCheckModifyEvent(Context context) {
        state.firstCheckModifyEvent(this);
    }

    /**
     * 二审通过事件，状态由二审待审到二审通过
     *
     * @param context
     */
    @Override
    public void secondCheckPassEvent(Context context) {
        state.secondCheckPassEvent(this);
    }

    /**
     * 二审驳回事件，状态由二审待审到二审驳回
     *
     * @param context
     */
    @Override
    public void secondCheckRejectEvent(Context context) {
        state.secondCheckRejectEvent(this);
    }

    /**
     * 二审修改事件，状态由二审驳回到二审待审
     *
     * @param context
     */
    @Override
    public void secondCheckModifyEvent(Context context) {
        state.secondCheckModifyEvent(this);
    }

    /**
     * 三审通过事件，状态由三审待审到可分发
     *
     * @param context
     */
    @Override
    public void thirdCheckPassEvent(Context context) {
        state.thirdCheckPassEvent(this);
    }

    /**
     * 三审驳回事件，状态由三审待审到三审驳回
     *
     * @param context
     */
    @Override
    public void thirdCheckRejectEvent(Context context) {
        state.thirdCheckRejectEvent(this);
    }

    /**
     * 三审修改事件，状态由三审驳回到三审待审
     *
     * @param context
     */
    @Override
    public void thirdCheckModifyEvent(Context context) {
        state.thirdCheckModifyEvent(this);
    }

    /**
     * 查看当前状态
     *
     * @return
     */
    @Override
    public StateEnum getCurrentState() {
        return state.getCurrentState();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
