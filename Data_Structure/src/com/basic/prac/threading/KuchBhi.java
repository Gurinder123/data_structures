package com.prac.threading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class MyThread2 extends Thread{
    String name;
    private static final ReentrantLock reentrantLock = new ReentrantLock();
    MyThread2(String name){
        this.name = name;
    }
    public void run(){
        do {
            try {
                if (reentrantLock.tryLock(20, TimeUnit.MILLISECONDS)){
                    System.out.println("executing : "+ name);
                    Thread.sleep(500);
                    reentrantLock.unlock();
                    break;
                }else {
                    System.out.println("waiting "+ name);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (true);
    }
}

public class KuchBhi {
    public static void main(String[] args) {
        new MyThread2("Thread - 1").start();
        new MyThread2("Thread - 2").start();
    }
}