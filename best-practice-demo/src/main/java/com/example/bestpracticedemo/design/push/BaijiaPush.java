package com.example.bestpracticedemo.design.push;

import org.springframework.stereotype.Component;

/**
 * 百家推送
 *
 * @author Gary
 * @date 2020/2/21 17:20
 * @since jdk1.8
 **/
@Component
public class BaijiaPush extends PushTemplate {

    /**
     * 抽象方法，组装推送的数据
     *
     * @param pushResultInfo
     */
    @Override
    public void compose(PushResultInfo pushResultInfo) {
        System.out.println("组合百家" + pushResultInfo);
    }
}
