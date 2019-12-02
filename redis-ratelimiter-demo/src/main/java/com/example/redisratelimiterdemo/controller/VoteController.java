package com.example.redisratelimiterdemo.controller;

import com.example.redisratelimiterdemo.util.VoteUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

/**
 * 投票 Controller
 *
 * @author Gary
 * @date 2019/12/2 15:58
 * @since jdk1.8
 **/
@RestController
public class VoteController {

    @Autowired
    private VoteUtil voteUtil;

    private static Integer count = 0;

    @PostMapping("/vote")
    public void vote(@RequestParam("voter") String voter, @RequestParam("player") String player) throws InterruptedException {
        while (true){
            if (voteUtil.vote(voter, player)){
                count++;
            }
            TimeUnit.SECONDS.sleep(2);
            System.out.println(count + " " + LocalTime.now());
        }
    }
}
