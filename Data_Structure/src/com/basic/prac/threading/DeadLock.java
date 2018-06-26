package com.prac.threading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock extends Thread {
    ReentrantLock a;
    ReentrantLock b;
    CountDownLatch countDownLatch;

    public DeadLock(ReentrantLock a, ReentrantLock b, CountDownLatch countDownLatch) {
        this.a = a;
        this.b = b;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        System.out.println("Acquiring first lock");

        a.lock();

        countDownLatch.countDown();

        System.out.println("Lock first acquired");

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Acquiring second lock");
        b.lock();
        System.out.println("Lock second acquired");
    }

    public static void main(String[] args) {

        String s1 = "a";
        String s2 = "b";

        Thread t1 = new Thread(() -> {
            synchronized (s1) {
                System.out.println("Aquiring s1 lock ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (s2) {
                    System.out.println("Never called");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (s2) {
                System.out.println("Aquiring s2 lock ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (s1) {
                    System.out.println("Never called");
                }
            }
        });

        t1.start();
        t2.start();

    }

}
