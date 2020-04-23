package com.example.bestpracticedemo.design.check;

/**
 * 一审待审
 *
 * @author Gary
 * @date 2020/3/31 11:10
 **/
class FirstWaitState extends AbstractState {

    /**
     * 一审通过事件，状态由一审待审到二审待审
     *
     * @param context
     */
    @Override
    public void firstCheckPassEvent(Context context) {
        context.setState(new SecondWaitState());
    }

    /**
     * 一审驳回事件，状态由一审待审到一审驳回
     *
     * @param context
     */
    @Override
    public void firstCheckRejectEvent(Context context) {
        context.setState(new FirstRejectState());
    }

    /**
     * 查看当前状态
     *
     * @return
     */
    @Override
    public StateEnum getCurrentState() {
        return StateEnum.FIRST_WAIT;
    }
}

class SecondWaitState extends AbstractState {

    /**
     * 二审通过事件，状态由二审待审到三审待审
     *
     * @param context
     */
    @Override
    public void secondCheckPassEvent(Context context) {
        context.setState(new ThirdWaitState());
    }

    /**
     * 二审驳回事件，状态由二审待审到二审驳回
     *
     * @param context
     */
    @Override
    public void secondCheckRejectEvent(Context context) {
        context.setState(new SecondRejectState());
    }

    /**
     * 查看当前状态
     *
     * @return
     */
    @Override
    public StateEnum getCurrentState() {
        return StateEnum.SECOND_WAIT;
    }
}

class FirstRejectState extends AbstractState {

    /**
     * 一审修改事件，状态由一审驳回到一审待审
     *
     * @param context
     */
    @Override
    public void firstCheckModifyEvent(Context context) {
        context.setState(new FirstWaitState());
    }

    /**
     * 查看当前状态
     *
     * @return
     */
    @Override
    public StateEnum getCurrentState() {
        return StateEnum.FIRST_REJECT;
    }
}

class ThirdWaitState extends AbstractState {

    /**
     * 三审通过事件，状态由三审待审到可分发
     *
     * @param context
     */
    @Override
    public void thirdCheckPassEvent(Context context) {
        context.setState(new PublishableState());
    }

    /**
     * 三审驳回事件，状态由三审待审到三审驳回
     *
     * @param context
     */
    @Override
    public void thirdCheckRejectEvent(Context context) {
        context.setState(new ThirdRejectState());
    }

    /**
     * 查看当前状态
     *
     * @return
     */
    @Override
    public StateEnum getCurrentState() {
        return StateEnum.THIRD_WAIT;
    }
}

class SecondRejectState extends AbstractState {

    /**
     * 二审修改事件，状态由二审驳回到二审待审
     *
     * @param context
     */
    @Override
    public void secondCheckModifyEvent(Context context) {
        context.setState(new SecondWaitState());
    }

    /**
     * 查看当前状态
     *
     * @return
     */
    @Override
    public StateEnum getCurrentState() {
        return StateEnum.SECOND_REJECT;
    }
}

class PublishableState extends AbstractState {
    /**
     * 查看当前状态
     *
     * @return
     */
    @Override
    public StateEnum getCurrentState() {
        return StateEnum.PUBLISHABLE;
    }
}

class ThirdRejectState extends AbstractState {

    /**
     * 三审修改事件，状态由三审驳回到三审待审
     *
     * @param context
     */
    @Override
    public void thirdCheckModifyEvent(Context context) {
        context.setState(new ThirdWaitState());
    }

    /**
     * 查看当前状态
     *
     * @return
     */
    @Override
    public StateEnum getCurrentState() {
        return StateEnum.THIRD_REJECT;
    }
}