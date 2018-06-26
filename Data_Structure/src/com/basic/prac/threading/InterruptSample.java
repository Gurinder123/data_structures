package com.prac.threading;

public class InterruptSample extends Thread {

    synchronized public void run() {
        try {
            System.out.println("Going in waiting...");
            wait(4000);
            System.out.println("Ho gya wait");
        } catch (InterruptedException e) {
            System.out.println("Exiting");
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(new InterruptSample());
        t.start();

        Thread.sleep(3000);
        t.interrupt();
    }
}
