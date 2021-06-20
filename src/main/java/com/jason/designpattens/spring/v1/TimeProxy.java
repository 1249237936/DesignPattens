package com.jason.designpattens.spring.v1;

public class TimeProxy {

    public void before() {
        System.out.println("method start..." + System.currentTimeMillis());
    }

    public void after() {
        System.out.println("method start..." + System.currentTimeMillis());
    }
}
