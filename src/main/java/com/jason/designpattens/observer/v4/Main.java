package com.jason.designpattens.observer.v4;

class Child {
    private boolean cry = false;
    private Dad dad = new Dad();
    private Mum mum = new Mum();
    private Dog dog = new Dog();

    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        cry = true;
        dad.feed();
        mum.hug();
        dog.wang();
    }
}

class Dad {
    public void feed() {
        System.out.println("dad feeding...");
    }
}

class Mum {
    public void hug() {
        System.out.println("mum hugging...");
    }
}

class Dog {
    public void wang() {
        System.out.println("dog wanging...");
    }
}

public class Main {
    public static void main(String[] args) {
        Child c = new Child();
        //do something
        c.wakeUp();
    }
}
