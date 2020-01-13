package com.example.codedesigndemo.pattern.observer;

/**
 * 普通用户-订阅者
 *
 * @author Gary
 * @date 2020/1/11 17:29
 * @since jdk1.8
 **/
public class User implements Subscriber {
    private String username;

    public User(String username) {
        this.username = username;
    }

    @Override
    public int receive(String publisher, String article) {
        System.out.println(username + "收到" + publisher + "发的消息：" + article);
        return 0;
    }
}
