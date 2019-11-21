package com.example.redissonlockdemo.util;

import com.example.redissonlockdemo.config.DistributedLocker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Gary
 * @className RedissonLockUtil
 * @description TODO
 * @date 2019/11/19 15:42
 **/
@Component
public class RedissonLockUtil {

    private static DistributedLocker distributedLocker;

    @Autowired
    public void setDistributedLocker(DistributedLocker distributedLocker){
        RedissonLockUtil.distributedLocker = distributedLocker;
    }

    public static void lock(String lockKey){
        distributedLocker.lock(lockKey);
    }
}
