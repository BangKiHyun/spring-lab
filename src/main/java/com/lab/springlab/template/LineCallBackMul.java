package com.lab.springlab.template;

public class LineCallBackMul implements LineCallBack {

    @Override
    public int doSomethingWithLine(String line, int value) {
        return Integer.parseInt(line) * value;
    }
}
