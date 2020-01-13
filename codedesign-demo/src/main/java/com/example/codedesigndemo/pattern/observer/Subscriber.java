package com.example.codedesigndemo.pattern.observer;

public interface Subscriber {

    int receive(String publisher, String article);
}
