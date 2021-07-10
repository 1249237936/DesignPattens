package com.jason.designpattens.prototype.v1;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.ToString;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = (Person) p1.clone();
        System.out.println(p2.age + " " + p2.score);
        System.out.println(p2.loc);

        System.out.println(p1.loc == p2.loc);
        p1.loc.street = "sh";
        System.out.println(p2.loc);
    }
}

class Person implements Cloneable {
    int age = 8;
    int score = 100;

    Location loc = new Location("jb", 22);

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

@AllArgsConstructor
@ToString
class Location {
    String street;
    int roomNo;
}