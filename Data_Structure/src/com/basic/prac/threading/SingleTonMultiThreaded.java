package com.prac.threading;

public class SingleTonMultiThreaded {

    private static SingleTonMultiThreaded ourInstance;

    public static SingleTonMultiThreaded getInstance() {

        if (ourInstance == null)
            ourInstance = new SingleTonMultiThreaded();

        return ourInstance;
    }

    private SingleTonMultiThreaded() {
    }

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            while (true) {
                System.out.println(SingleTonMultiThreaded.getInstance());
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                System.out.println(SingleTonMultiThreaded.getInstance());
            }
        });

        Thread t3 = new Thread(() -> {
            while (true) {
                System.out.println(SingleTonMultiThreaded.getInstance());
            }
        });

        Thread t4 = new Thread(() -> {
            while (true) {
                System.out.println(SingleTonMultiThreaded.getInstance());
            }
        });
        Thread t5 = new Thread(() -> {
            while (true) {
                System.out.println(SingleTonMultiThreaded.getInstance());
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
