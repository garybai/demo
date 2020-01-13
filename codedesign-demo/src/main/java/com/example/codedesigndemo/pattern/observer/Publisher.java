package com.example.codedesigndemo.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 发送者
 *
 * @author Gary
 * @date 2020/1/11 17:31
 * @since jdk1.8
 **/
public class Publisher {
    private List<Subscriber> subscribers;

    public Publisher() {
        this.subscribers = new ArrayList<>();
    }

    public void subscribe(Subscriber subscriber){
        this.subscribers.add(subscriber);
    }

    public void unSubscribe(Subscriber subscriber){
        if (this.subscribers.contains(subscriber)){
            this.subscribers.remove(subscriber);
        } else {
            System.out.println("不存在");
        }
    }

    public void notifySubscribers(String publisher, String article){
        for (Subscriber subscriber : this.subscribers){
            subscriber.receive(publisher, article);
        }
    }
}
