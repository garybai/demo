package com.example.bestpracticedemo.design.push;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 头条推送适配器
 *
 * @author Gary
 * @date 2020/2/21 17:34
 * @since jdk1.8
 **/
@Component
public class ToutiaoPushAdapter implements PushAdapter {

    private static final String PLATFORM = "toutiao";

    @Autowired
    private PushTemplate toutiaoPush;

    @Override
    public boolean support(PushResultInfo pushResultInfo) {
        return pushResultInfo.getPlatform().equalsIgnoreCase(PLATFORM);
    }

    @Override
    public void push(PushResultInfo pushResultInfo) {
        toutiaoPush.push(pushResultInfo);
    }
}
