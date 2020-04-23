package com.example.bestpracticedemo.design.check;

/**
 * 审核测试类
 *
 * @author Gary
 * @date 2020/3/31 11:52
 **/
public class CheckTest {

    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new FirstWaitState());
        System.out.println(context.getCurrentState());
        context.firstCheckPassEvent(context);
        System.out.println(context.getCurrentState());
        context.secondCheckRejectEvent(context);
        System.out.println(context.getCurrentState());
        context.secondCheckModifyEvent(context);
        System.out.println(context.getCurrentState());
        context.secondCheckPassEvent(context);
        System.out.println(context.getCurrentState());
        context.thirdCheckPassEvent(context);
        System.out.println(context.getCurrentState());
        context.secondCheckRejectEvent(context);
        System.out.println(context.getCurrentState());
    }

}
