package com.example.dubboconsumerdemo.controller;

import com.example.dubbointerfacedemo.service.GoodsService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * controller
 *
 * @author Gary
 * @date 2022/9/24 18:40
 **/
@RestController
@RequestMapping("/goods")
public class DemoController {

    @DubboReference
    private GoodsService goodsService;

    @RequestMapping("/get")
    public String getData() {
        goodsService.getGoods();
        return goodsService.getData("data");
    }
}
