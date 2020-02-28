package com.example.bestpracticedemo.design.push;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 百家推送适配器
 *
 * @author Gary
 * @date 2020/2/21 17:34
 * @since jdk1.8
 **/
@Component
public class BaijiaPushAdapter implements PushAdapter {

    private static final String PLATFORM = "baijia";

    @Autowired
    private PushTemplate baijiaPush;

    @Override
    public boolean support(PushResultInfo pushResultInfo) {
        return pushResultInfo.getPlatform().equalsIgnoreCase(PLATFORM);
    }

    @Override
    public void push(PushResultInfo pushResultInfo) {
        baijiaPush.push(pushResultInfo);
    }
}
