package com.example.codedesigndemo.pattern.strategy;

import com.alibaba.fastjson.JSONObject;

/**
 * 头条组装
 *
 * @author Gary
 * @date 2020/1/11 16:52
 * @since jdk1.8
 **/
public class ToutiaoCompose extends Compose {
    @Override
    String compose(String content) {
        JSONObject object = new JSONObject();
        object.put("platform", "toutiao");
        object.put("content", content);
        return object.toJSONString();
    }
}
