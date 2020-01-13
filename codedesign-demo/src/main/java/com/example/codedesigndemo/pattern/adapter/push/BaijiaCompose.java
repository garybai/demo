package com.example.codedesigndemo.pattern.adapter.push;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

/**
 * baijia平台组装json
 *
 * @author Gary
 * @date 2020/1/11 13:23
 * @since jdk1.8
 **/
@Component
public class BaijiaCompose implements Compose {

//    private PushResultInfo pushResultInfo;
//
//    public BaijiaCompose(PushResultInfo pushResultInfo) {
//        this.pushResultInfo = pushResultInfo;
//    }
//
//    @Override
//    public String getPlatform() {
//        return pushResultInfo.getPlatform();
//    }

    @Override
    public String compose(PushResultInfo pushResultInfo) {
        System.out.println("组装百家json");
        JSONObject object = new JSONObject();
        object.put("platform", pushResultInfo.getPlatform());
        object.put("articleId", pushResultInfo.getArtid());
        object.put("title", pushResultInfo.getTitle());
        return object.toJSONString();
    }
}
