package com.jason.designpattens.prototype.v4;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.ToString;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = (Person) p1.clone();
        System.out.println("p1.loc == p2.loc = " + (p1.loc == p2.loc));

        p1.loc.street.reverse();
        System.out.println(p2.loc.street);
    }
}

class Person implements Cloneable {
    int age = 8;
    int score = 100;

    Location loc = new Location(new StringBuilder("bj"), 22);

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person p = (Person) super.clone();
        p.loc = (Location) loc.clone();
        return p;
    }
}

@ToString
@AllArgsConstructor
class Location implements Cloneable {
    StringBuilder street;
    int roomNo;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
