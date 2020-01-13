package com.example.codedesigndemo.pattern.adapter.push;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * push
 *
 * @author Gary
 * @date 2020/1/11 11:32
 * @since jdk1.8
 **/
@RestController
public class PushController {

    @Autowired
    private PushService pushService;

    @PostMapping("/article/push")
    public void push(@RequestBody PushResultInfo pushResultInfo){
//        PushResultInfo pushResultInfo1 = new PushResultInfo(1L, 1L, "我是标题", "toutiao");
        pushService.push(pushResultInfo);
    }
}
