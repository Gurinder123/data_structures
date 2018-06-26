package com.prac.threading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FutureExample implements Callable<String>, Runnable {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.submit(new FutureExample(), "Why me?");
        executorService.shutdown();
    }


    @Override
    public void run() {
        System.out.println("Run called");
    }

    @Override
    public String call() throws Exception {
        System.out.println("Callable called");
        return "something";
    }
}
