package com.jason.designpattens.singleton;

import java.util.concurrent.*;

public class Singleton4 {

    private static Singleton4 INSTANCE;

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Singleton4();
        }

        return INSTANCE;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Singleton4> c = Singleton4::getInstance;

        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Singleton4> f1 = es.submit(c);
        Future<Singleton4> f2 = es.submit(c);
        Singleton4 s1 = f1.get();
        Singleton4 s2 = f2.get();

        System.out.println("s1 == s2 :" + (s1 == s2));
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);

        es.shutdown();
    }
}
