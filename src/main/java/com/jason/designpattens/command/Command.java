package com.jason.designpattens.command;

public abstract class Command {
    public abstract void doit();
    public abstract void undo();
}