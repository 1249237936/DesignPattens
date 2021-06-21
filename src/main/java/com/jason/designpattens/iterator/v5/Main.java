package com.jason.designpattens.iterator.v5;

public class Main {
    public static void main(String[] args) {
        Collection_ list = new LinkedList_();
        for (int i = 0; i < 15; i++) {
            list.add(new String("s" + i));
        }
        System.out.println(list.size());

        Iterator_ i = list.iterator();
        while (i.hasNext()) {
            Object o = i.next();
            System.out.println(o);
        }
    }
}

interface Iterator_ {
    boolean hasNext();
    Object next();
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

    @Override
    public Iterator_ iterator() {
        return new Iter();
    }
    private class Iter implements Iterator_{

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }
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

    @Override
    public Iterator_ iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator_{
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < index;
        }

        @Override
        public Object next() {
            Object o = objects[currentIndex];
            currentIndex++;
            return o;
        }
    }
}

interface Collection_ {
    void add(Object o);
    int size();
    Iterator_ iterator();
}