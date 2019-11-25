package com.example.bloomfilterdemo.service;

import com.example.bloomfilterdemo.config.BloomFilterHelper;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Gary
 * @className RedisService
 * @description TODO
 * @date 2019/11/22 10:59
 **/
@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 根据给定的布隆过滤器添加值
     */
    public <T> void addByBloomFilter(BloomFilterHelper<T> bloomFilterHelper, String key, T value) {
        Preconditions.checkArgument(bloomFilterHelper != null, "bloomFilterHelper不能为空");
        int[] offset = bloomFilterHelper.murmurHashOffset(value);
        for (int i : offset) {
//            System.out.println("key : " + key + " " + "value : " + i);
            redisTemplate.opsForValue().setBit(key, i, true);
        }
    }

    /**
     * 根据给定的布隆过滤器判断值是否存在
     */
    public <T> boolean includeByBloomFilter(BloomFilterHelper<T> bloomFilterHelper, String key, T value) {
        Preconditions.checkArgument(bloomFilterHelper != null, "bloomFilterHelper不能为空");
        int[] offset = bloomFilterHelper.murmurHashOffset(value);
        for (int i : offset) {
//            System.out.println("key : " + key + " " + "value : " + i);
            Boolean bit = redisTemplate.opsForValue().getBit(key, i);
            if (null == bit) {
                return false;
            }
            if (!bit) {
                return false;

            }
        }

        return true;
    }

}
