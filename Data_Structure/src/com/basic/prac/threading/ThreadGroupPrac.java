package com.prac.threading;

public class ThreadGroupPrac implements Runnable {

    public static void main(String[] args) {

        ThreadGroup threadGroup = new ThreadGroup("My Thread Group");

        Thread first_thread = new Thread(threadGroup, new ThreadGroupPrac(), "first thread");
        first_thread.start();
        first_thread.start();

        new Thread(threadGroup, new ThreadGroupPrac(), "second thread").start();
        new Thread(threadGroup, new ThreadGroupPrac(), "third thread").start();

        threadGroup.list();
    }

    @Override
    public void run() {
        System.out.println("Thread name " + Thread.currentThread());
    }
}
