package com.example.codedesigndemo.pattern.observer;

/**
 * 观察者模式测试
 *
 * @author Gary
 * @date 2020/1/11 17:38
 * @since jdk1.8
 **/
public class ObserverTest {

    public static void main(String[] args) {
        WeChatAccount weChatAccount = new WeChatAccount("Java公众号");
        User user1 = new User("张三");
        User user2 = new User("李四");
        User user3 = new User("王五");
        weChatAccount.subscribe(user1);
        weChatAccount.subscribe(user2);
        weChatAccount.subscribe(user3);

        weChatAccount.publishArticle("观察者模式讲解");

        System.out.println("---------");
        weChatAccount.unSubscribe(user1);
        weChatAccount.publishArticle("观察者模式讲解");
    }
}
