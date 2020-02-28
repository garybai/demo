package com.example.bestpracticedemo.design.push;

public interface PushAdapter {

    boolean support(PushResultInfo pushResultInfo);

    void push(PushResultInfo pushResultInfo);

}
