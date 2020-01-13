package com.example.codedesigndemo.pattern.adapter.push;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 头条推送适配器
 *
 * @author Gary
 * @date 2020/1/11 10:52
 * @since jdk1.8
 **/
@Component("toutiaoPushAdapter")
public class ToutiaoPushAdapter implements PushAdapter {

    @Resource(name = "toutiaoCompose")
    private Compose toutiaoCompose;

    private static final String PLATFORM = "toutiao";

    @Override
    public boolean support(PushResultInfo pushResultInfo) {
        return pushResultInfo.getPlatform().equalsIgnoreCase(PLATFORM);
    }

    @Override
    public void push(PushResultInfo pushResultInfo) {
        String s = this.toutiaoCompose.compose(pushResultInfo);
        System.out.println("调用推送接口：" + s);
    }
}
