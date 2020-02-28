package com.example.bestpracticedemo.design.push;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 推送测试
 *
 * @author Gary
 * @date 2020/2/21 17:39
 * @since jdk1.8
 **/
@RestController
public class PushController {

    @Autowired
    private PushService pushService;

    @PostMapping("/article/push")
    public void push(@RequestBody PushResultInfo pushResultInfo) {
        System.out.println(pushResultInfo);
//        PushResultInfo pushResultInfo1 = new PushResultInfo(1L, 1L, "我是标题", "toutiao");
        pushService.push(pushResultInfo);
    }
}
