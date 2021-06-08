package com.jason.designpattens.factory;

public class Broom implements MoveAble{
    @Override
    public void go() {
        System.out.println("Broom flying chuachuachua...");
    }
}
