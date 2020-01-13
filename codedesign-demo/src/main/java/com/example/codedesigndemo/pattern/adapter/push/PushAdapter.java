package com.example.codedesigndemo.pattern.adapter.push;

public interface PushAdapter {

    boolean support(PushResultInfo pushResultInfo);

    void push(PushResultInfo pushResultInfo);
}
