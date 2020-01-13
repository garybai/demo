package com.example.codedesigndemo.pattern.adapter.ac;

public interface DC5Adapter {
    boolean support(AC ac);
    int outputDC5(AC ac);
}
