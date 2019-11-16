package com.example.redislockdemo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Gary
 * @className RedisLockUtil
 * @description TODO
 * @date 2019-11-14 17:28
 **/
@Component
public class RedisLockUtil1 {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    // 默认自旋超时时间
    private long timeout = 3000;

    public Boolean lock(String key) {
        long start = System.currentTimeMillis();
        while (true) {
            // 如果超过了 3s 的默认超时时间，停止自旋
            if ((System.currentTimeMillis() - start) > timeout) {
                System.out.println(Thread.currentThread().getName() + "未获取锁。。。超时");
                return false;
            }
            Boolean absent = redisTemplate.opsForValue().setIfAbsent(key, "1");
            if (absent == null) {
                return false;
            }
            if (absent) {
                System.out.println(Thread.currentThread().getName() + "获取到锁");
                return true;
            }
            System.out.println(Thread.currentThread().getName() + "未获取锁。。。自旋");
        }
    }

    public Boolean unlock(String key) {
        Boolean delete = redisTemplate.delete(key);
        return delete == null ? false : delete;
    }

}
