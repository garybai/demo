package com.example.codedesigndemo.pattern.strategy;

/**
 * 推送
 *
 * @author Gary
 * @date 2020/1/11 16:54
 * @since jdk1.8
 **/
public class PushService {

    private Compose compose;

    public PushService(Compose compose) {
        this.compose = compose;
    }

    public String articleCompose(String content){
        return compose.compose(content);
    }
}
