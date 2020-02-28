package com.example.bestpracticedemo.design.push;

/**
 * 推送抽象类
 *
 * @author Gary
 * @date 2020/2/21 17:11
 * @since jdk1.8
 **/
public abstract class PushTemplate {

    /**
     * 校验html内容
     * @param pushResultInfo
     * @return
     */
    public final Boolean checkHtml(PushResultInfo pushResultInfo){
        return true;
    }

    /**
     * 校验24小时内是否发过相同标题文章
     * @param pushResultInfo
     * @return
     */
    public final Boolean check24Hours(PushResultInfo pushResultInfo){
        return true;
    }

    /**
     * 抽象方法，组装推送的数据
     * @param pushResultInfo
     */
    public abstract void compose(PushResultInfo pushResultInfo);

    /**
     * 调用推送api接口
     * @param pushResultInfo
     */
    public final void api(PushResultInfo pushResultInfo){
        System.out.println("调用api" + pushResultInfo);
    }

    /**
     * 整体推送流程
     * @param pushResultInfo
     */
    public final void push(PushResultInfo pushResultInfo){
        if (!this.checkHtml(pushResultInfo)) {
            return;
        }
        if (!this.check24Hours(pushResultInfo)) {
            return;
        }
        this.compose(pushResultInfo);
        this.api(pushResultInfo);
    }
}
