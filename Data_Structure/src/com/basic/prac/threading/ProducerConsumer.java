package com.prac.threading;

public class ProducerConsumer {
    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();

        new Produce(sharedResource).start();
        new Produce(sharedResource).start();

    }
}

class SharedResource {

    private int data;

    synchronized public void write() throws InterruptedException {

        while (this.data % 2 == 1) {
            System.out.println("Writing data " + (++this.data));
            wait();
        }

        System.out.println("Writing data " + (++this.data));
        notifyAll();
    }

}

class Produce extends Thread {

    private SharedResource sharedResource;


    public Produce(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {

        for (int i = 1; i <= 5; ++i) {
            try {
                sharedResource.write();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Loop done");
    }
}

