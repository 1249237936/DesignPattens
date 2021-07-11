package com.jason.designpattens.templatemethod;

public class Main {
    public static void main(String[] args) {
        F f = new C1();
        f.m();
    }
}

abstract class F {
    public void m() {
        op1();
        op2();
    }

    protected abstract void op1();
    protected abstract void op2();

}

class C1 extends F {
    @Override
    protected void op1() {
        System.out.println("op1");
    }

    @Override
    protected void op2() {
        System.out.println("op2");
    }
}