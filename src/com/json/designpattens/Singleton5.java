package com.json.designpattens;

import java.util.concurrent.*;

public class Singleton5 {

    private static Singleton5 INSTANCE;

    private Singleton5() {
    }

    public static Singleton5 getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton5.class) {
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Singleton5();
                }
            }
        }

        return INSTANCE;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Singleton5> c = Singleton5::getInstance;

        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Singleton5> f1 = es.submit(c);
        Future<Singleton5> f2 = es.submit(c);
        Singleton5 s1 = f1.get();
        Singleton5 s2 = f2.get();

        System.out.println("s1 == s2 :" + (s1 == s2));
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);

        es.shutdown();
    }
}
