package com.jason.designpattens.state.thread;

public abstract class ThreadState_ {
    abstract void move(Action input);
    abstract void run();
}
