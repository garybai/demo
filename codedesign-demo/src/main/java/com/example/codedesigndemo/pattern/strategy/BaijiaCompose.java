package com.example.codedesigndemo.pattern.strategy;

import com.alibaba.fastjson.JSONObject;

/**
 * 百家组装
 *
 * @author Gary
 * @date 2020/1/11 16:53
 * @since jdk1.8
 **/
public class BaijiaCompose extends Compose {
    @Override
    String compose(String content) {
        JSONObject object = new JSONObject();
        object.put("platform", "baijia");
        object.put("content", content);
        return object.toJSONString();
    }
}
