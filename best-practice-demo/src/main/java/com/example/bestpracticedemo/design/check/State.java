package com.example.bestpracticedemo.design.check;

/**
 * 状态接口
 * @author Gary
 * @date 2020/3/31 10:41
 **/
public interface State {

    /**
     * 一审通过事件，状态由一审待审到二审待审
     * @param context
     */
    void firstCheckPassEvent(Context context);

    /**
     * 一审驳回事件，状态由一审待审到一审驳回
     * @param context
     */
    void firstCheckRejectEvent(Context context);

    /**
     * 一审修改事件，状态由一审驳回到一审待审
     * @param context
     */
    void firstCheckModifyEvent(Context context);

    /**
     * 二审通过事件，状态由二审待审到二审通过
     * @param context
     */
    void secondCheckPassEvent(Context context);

    /**
     * 二审驳回事件，状态由二审待审到二审驳回
     * @param context
     */
    void secondCheckRejectEvent(Context context);

    /**
     * 二审修改事件，状态由二审驳回到二审待审
     * @param context
     */
    void secondCheckModifyEvent(Context context);

    /**
     * 三审通过事件，状态由三审待审到可分发
     * @param context
     */
    void thirdCheckPassEvent(Context context);

    /**
     * 三审驳回事件，状态由三审待审到三审驳回
     * @param context
     */
    void thirdCheckRejectEvent(Context context);

    /**
     * 三审修改事件，状态由三审驳回到三审待审
     * @param context
     */
    void thirdCheckModifyEvent(Context context);

    /**
     * 查看当前状态
     * @return
     */
    StateEnum getCurrentState();

}
