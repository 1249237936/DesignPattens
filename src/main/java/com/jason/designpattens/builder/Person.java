package com.jason.designpattens.builder;

public class Person {
    private int id;
    private String name;
    private int age;
    private double weight;
    private int score;
    private Location location;
    private Person(){}

    public static class PersonBuilder {
        private Person p = new Person();

        public PersonBuilder basicInfo(int id, String name, int age) {
            p.id = id;
            p.name = name;
            p.age = age;
            return this;
        }

        public PersonBuilder weight(double weight) {
            p.weight = weight;
            return this;
        }

        public PersonBuilder score(int score) {
            p.score = score;
            return this;
        }

        public PersonBuilder loc(String street, String roomNo) {
            p.location = new Location(street, roomNo);
            return this;
        }

        public Person build() {
            return p;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", score=" + score +
                ", location=" + location +
                '}';
    }
}

class Location {
    private String street;
    private String roomNo;

    public Location(String street, String roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }

    @Override
    public String toString() {
        return "Location{" +
                "street='" + street + '\'' +
                ", roomNo='" + roomNo + '\'' +
                '}';
    }
}