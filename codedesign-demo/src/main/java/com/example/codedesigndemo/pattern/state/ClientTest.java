package com.example.codedesigndemo.pattern.state;

/**
 * 测试类
 *
 * @author Gary
 * @date 2020/3/30 22:37
 **/
public class ClientTest {

    public static void main(String[] args) {

        RaffleActivity activity = new RaffleActivity(1);

        for (int i = 0; i < 10; i++) {
            System.out.println("-------第" + (i + 1) + "次抽奖-------");
            activity.deductMoney();
            activity.raffle();
        }
    }
}
