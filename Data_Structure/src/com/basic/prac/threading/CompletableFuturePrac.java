package com.prac.threading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFuturePrac {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            try{
                Thread.sleep(4000);
            }catch (Exception e){

            }
            return 1;});

        completableFuture = completableFuture.thenApply((i) -> i + 1);

        System.out.println("Done=>>>>>>>>");
        System.out.println(completableFuture.cancel(true));
        System.out.println(completableFuture.isDone());
        System.out.println(completableFuture.isCancelled());
    }
}
