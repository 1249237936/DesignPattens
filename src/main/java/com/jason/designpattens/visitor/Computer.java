package com.jason.designpattens.visitor;

public class Computer {
    ComputerPart cpu = new CPU();
    ComputerPart memory = new Memory();
    ComputerPart board = new Board();

    public void accept(Visitor visitor) {
        this.cpu.accept(visitor);
        this.memory.accept(visitor);
        this.board.accept(visitor);
    }

    public static void main(String[] args) {
        PersonVisitor personVisitor = new PersonVisitor();
        new Computer().accept(personVisitor);
        System.out.println(personVisitor.totalPrice);

        CorpVisitor corpVisitor = new CorpVisitor();
        new Computer().accept(corpVisitor);
        System.out.println(corpVisitor.totalPrice);
    }
}

abstract class ComputerPart {
    abstract void accept(Visitor v);
    abstract double getPrice();
}

interface Visitor {
    void visitCpu(CPU cpu);
    void visitMemory(Memory memory);
    void visitBoard(Board bord);
}
class CPU extends ComputerPart {
    @Override
    void accept(Visitor v) {
        v.visitCpu(this);
    }

    @Override
    double getPrice() {
        return 500;
    }
}

class Memory extends ComputerPart {
    @Override
    void accept(Visitor v) {
        v.visitMemory(this);
    }

    @Override
    double getPrice() {
        return 300;
    }
}

class Board extends ComputerPart {
    @Override
    void accept(Visitor v) {
        v.visitBoard(this);
    }

    @Override
    double getPrice() {
        return 200;
    }
}

class PersonVisitor implements Visitor {
    double totalPrice = 0.0;

    @Override
    public void visitCpu(CPU cpu) {
        totalPrice += cpu.getPrice() * 0.9;
    }

    @Override
    public void visitMemory(Memory memory) {
        totalPrice += memory.getPrice() * 0.85;
    }

    @Override
    public void visitBoard(Board bord) {
        totalPrice += bord.getPrice() * 0.95;
    }
}

class CorpVisitor implements Visitor {
    double totalPrice = 0.0;

    @Override
    public void visitCpu(CPU cpu) {
        totalPrice += cpu.getPrice() * 0.6;
    }

    @Override
    public void visitMemory(Memory memory) {
        totalPrice += memory.getPrice() * 0.75;
    }

    @Override
    public void visitBoard(Board bord) {
        totalPrice += bord.getPrice() * 0.75;
    }
}