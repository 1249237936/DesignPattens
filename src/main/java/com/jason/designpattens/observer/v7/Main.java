package com.jason.designpattens.observer.v7;

import java.util.ArrayList;
import java.util.List;

class Child {
    private boolean cry = false;
    private List<Observer> observers = new ArrayList<>();
    {
        observers.add(new Dad());
        observers.add(new Mum());
        observers.add(new Dog());
    }

    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        cry = true;

        WakeUpEvent event = new WakeUpEvent(System.currentTimeMillis(), "bed", this);

        for (Observer o : observers) {
            o.actionOnWakeUp(event);
        }
    }
}

class Dad implements Observer {
    public void feed() {
        System.out.println("dad feeding...");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        feed();
    }
}

class Mum implements Observer {
    public void hug() {
        System.out.println("mum hugging...");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        hug();
    }
}

class Dog implements Observer {
    public void wang() {
        System.out.println("dog wanging...");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        wang();
    }
}

interface Observer {
    void actionOnWakeUp(WakeUpEvent event);
}

class WakeUpEvent {
    long timeStamp;
    String loc;
    Child source;

    public WakeUpEvent(long timeStamp, String loc, Child source) {
        this.timeStamp = timeStamp;
        this.loc = loc;
        this.source = source;
    }
}

public class Main {
    public static void main(String[] args) {
        Child c = new Child();

        c.wakeUp();
    }
}
