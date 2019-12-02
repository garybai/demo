package com.example.redisratelimiterdemo;

import com.example.redisratelimiterdemo.util.VoteUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisRatelimiterDemoApplicationTests {

    @Autowired
    VoteUtil voteUtil;

    @Test
    public void contextLoads() {
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void test(){
        voteUtil.vote("a","p2");
    }

}
