package com.example.bloomfilterdemo.controller;

import com.example.bloomfilterdemo.config.BloomFilterHelper;
import com.example.bloomfilterdemo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gary
 * @className RedisController
 * @description TODO
 * @date 2019/11/22 10:19
 **/
@RestController
public class RedisController {

    @Autowired
    private static RedisService redisService;

    @Autowired
    private static BloomFilterHelper<String> bloomFilterHelper;

    private static int size = 1000000;

    private static int count = 0;

    public static void main(String[] args) {
        for (int i = 0; i < size; i++) {
            redisService.addByBloomFilter(bloomFilterHelper, "bloomKey", String.valueOf(i));
        }
        for (int i = 1000001; i < 2000000; i++) {
            boolean bloomKey = redisService.includeByBloomFilter(bloomFilterHelper, "bloomKey", String.valueOf(i));
            if (bloomKey) {
                count++;
            }
        }
        System.out.println(count);
    }

}
