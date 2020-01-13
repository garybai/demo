package com.example.codedesigndemo.pattern.strategy;

/**
 * 策略模式测试
 *
 * @author Gary
 * @date 2020/1/11 16:58
 * @since jdk1.8
 **/
public class StrategyTest {

    public static void main(String[] args) {
        PushService service = new PushService(new ToutiaoCompose());
        String s = service.articleCompose("文章内容");
        System.out.println(s);

        PushService service1 = new PushService(new BaijiaCompose());
        String s1 = service1.articleCompose("文章内容");
        System.out.println(s1);
    }
}
