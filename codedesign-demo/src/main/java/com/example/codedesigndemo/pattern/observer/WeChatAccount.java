package com.example.codedesigndemo.pattern.observer;

/**
 * 微信公众号-具体发布者
 *
 * @author Gary
 * @date 2020/1/11 17:35
 * @since jdk1.8
 **/
public class WeChatAccount extends Publisher {

    private String name;

    public WeChatAccount(String name) {
        this.name = name;
    }

    public void publishArticle(String article){
        System.out.println(name + "发布了文章：" + article);
        notifySubscribers(name, article);
    }
}
