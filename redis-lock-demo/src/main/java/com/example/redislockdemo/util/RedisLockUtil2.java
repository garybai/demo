package com.example.redislockdemo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author Gary
 * @className RedisLockUtil
 * @description TODO
 * @date 2019-11-14 17:28
 **/
@Component
public class RedisLockUtil2 {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    // 默认自旋超时时间
    private long timeout = 30000;

    public Boolean lock(String key) {
        long start = System.currentTimeMillis();
        while (true) {
            // 如果超过了 30s 的默认超时时间，停止自旋
            if ((System.currentTimeMillis() - start) > timeout) {
                System.out.println(Thread.currentThread().getName() + "未获取锁。。。超时");
                return false;
            }
            // 给锁设置了默认 30s 的过期时间，如果服务器宕机不能主动解锁，则 key 到期会失效，避免死锁问题
            Boolean absent = redisTemplate.opsForValue().setIfAbsent(key, "1", timeout, TimeUnit.MILLISECONDS);

            // 这种方法不可取，不能保证原子性
//            Boolean absent1 = redisTemplate.opsForValue().setIfAbsent(key, "1");
//            redisTemplate.expire(key, timeout, TimeUnit.MILLISECONDS);

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
