package com.example.dubboproviderdemo.service;

import com.example.dubbointerfacedemo.service.GoodsService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * 商品Service实现
 *
 * @author Gary
 * @date 2022/9/24 18:38
 **/
@DubboService
public class GoodsServiceImpl implements GoodsService {
    @Override
    public String getData(String data) {
        System.out.println("getData方法调用，data：" + data);
        return null;
    }

    @Override
    public String getGoods() {
        System.out.println("getGoods方法调用");
        return null;
    }
}
