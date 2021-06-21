package com.jason.designpattens.iterator.v4;

public class Main {
    public static void main(String[] args) {
        Collection_ list = new ArrayList_();
        for (int i = 0; i < 15; i++) {
            list.add(new String("s" + i));
        }
        System.out.println(list.size());

        ArrayList_ arrayList_ = (ArrayList_) list;
    }
}

class LinkedList_ implements Collection_{
    Node head = null;
    Node tail = null;
    private int size = 0;

    public void add(Object o) {
        Node n = new Node(o);

        if (head == null) {
            head = n;
            tail = n;
        }

        tail.next = n;
        tail = n;
        size++;
    }

    private class Node {
        private Object o;
        Node next;

        public Node(Object o) {
            this.o = o;
        }
    }

    public int size() {
        return size;
    }
}

class ArrayList_ implements Collection_{
    Object[] objects = new Object[10];

    private int index = 0;
    public void add(Object o) {
        if (index == objects.length) {
            Object[] newObjects = new Object[objects.length * 2];
            System.arraycopy(objects, 0, newObjects, 0, objects.length);
            objects = newObjects;
        }
        objects[index] = o;
        index++;
    }

    public int size() {return index;}


}

interface Collection_{
    void add(Object o);
    int size();
}