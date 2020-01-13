package com.example.codedesigndemo.pattern.adapter.push;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试
 *
 * @author Gary
 * @date 2020/1/11 11:16
 * @since jdk1.8
 **/
@Service
public class PushService {

    @Resource(name = "toutiaoPushAdapter")
    private PushAdapter toutiaoPushAdapter;

    @Resource(name = "baijiaPushAdapter")
    private PushAdapter baijiaPushAdapter;

    private List<PushAdapter> adapters = new ArrayList<>();

    @PostConstruct
    public void init(){
        this.adapters.add(toutiaoPushAdapter);
        this.adapters.add(baijiaPushAdapter);
    }

    private PushAdapter getAdapter(PushResultInfo pushResultInfo) {
        PushAdapter adapter = null;
        for (PushAdapter ad : adapters) {
            if (ad.support(pushResultInfo)) {
                adapter = ad;
                break;
            }
        }
        if (adapter == null) {
            throw new IllegalArgumentException("平台不支持");
        }
        return adapter;
    }

    public void push(PushResultInfo pushResultInfo){
        PushAdapter adapter = getAdapter(pushResultInfo);
        adapter.push(pushResultInfo);
    }

}
