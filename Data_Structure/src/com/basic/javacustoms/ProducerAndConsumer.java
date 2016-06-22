package com.basic.javacustoms;

/**
 * Created by gurinder on 22/6/16.
 */
public class ProducerAndConsumer {
    public static void main(String[] args) {
        Shareable shareable = new Shareable();
        Thread producer = new Producer(shareable);
        Thread consumer = new Consumer(shareable);
        consumer.start();
        producer.start();

    }
}

class Shareable {
    private boolean available = false;
    private int content;

    synchronized public void put(int val) {
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        available = true;
        content = val;
        notifyAll();
    }

    synchronized public int get() {
        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        available = false;
        notifyAll();
        return content;
    }
}

class Producer extends Thread {
    private Shareable shareable;

    public Producer(Shareable shareable) {
        this.shareable = shareable;
    }

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            System.out.println("Producing: " + i);
            shareable.put(i);
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    private Shareable shareable;

    public Consumer(Shareable shareable) {
        this.shareable = shareable;
    }

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            int val = shareable.get();
            System.out.println("Consuming: " + val);
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}