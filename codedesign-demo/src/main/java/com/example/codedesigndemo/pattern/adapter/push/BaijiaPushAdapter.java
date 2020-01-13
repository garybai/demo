package com.example.codedesigndemo.pattern.adapter.push;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 百家推送适配器
 *
 * @author Gary
 * @date 2020/1/11 10:52
 * @since jdk1.8
 **/
@Component("baijiaPushAdapter")
public class BaijiaPushAdapter implements PushAdapter {

    @Resource(name = "baijiaCompose")
    private Compose baijiaCompose;

    private static final String PLATFORM = "baijia";

    @Override
    public boolean support(PushResultInfo pushResultInfo) {
        return pushResultInfo.getPlatform().equalsIgnoreCase(PLATFORM);
    }

    @Override
    public void push(PushResultInfo pushResultInfo) {
        String s = this.baijiaCompose.compose(pushResultInfo);
        System.out.println("调用推送接口：" + s);
    }
}
