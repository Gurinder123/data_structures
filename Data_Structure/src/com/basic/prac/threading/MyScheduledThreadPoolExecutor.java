package com.prac.threading;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static java.util.Objects.nonNull;

public class MyScheduledThreadPoolExecutor implements Runnable {


    private Thread[] threadGroup;
    private NavigableMap<Long, Runnable> treeMap;

    public MyScheduledThreadPoolExecutor(int nThreads) {

        threadGroup = new Thread[nThreads];
        treeMap = new TreeMap<>();
    }

    /**
     * schedule task to be executed after @time
     */
    public void schedule(Runnable task, long time, TimeUnit unit) {

        // will compare and sort in ascending order and poll the time stamp with minimum wait
        treeMap.put(unit.toMillis(time), task);
    }

    /**
     * schedule task to be executed after every @time
     */
    public void scheduleAtInterval(Runnable task, long time, TimeUnit unit) {
    }


    public void forceShutDown() {

        for (Thread t : threadGroup) {
            if (nonNull(t) && !t.isInterrupted()) {
                try {
                    System.out.println(Thread.currentThread().getName()+" going to wait state");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        MyScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new MyScheduledThreadPoolExecutor(3);

        // Adding first task will wait for 10 seconds
        scheduledThreadPoolExecutor.schedule(() -> {
            System.out.println("Print something for me after certain delay ==== my delay is 10 seconds");
        }, 10000, TimeUnit.MILLISECONDS);

        // Adding second task will wait for 2 seconds
        scheduledThreadPoolExecutor.schedule(() -> {
            System.out.println("Print something for me after certain delay ==== my delay is 2 seconds");
        }, 2000, TimeUnit.MILLISECONDS);

        for (Thread t : scheduledThreadPoolExecutor.threadGroup) {
            t = new Thread(scheduledThreadPoolExecutor);
            t.start();
        }


        scheduledThreadPoolExecutor.forceShutDown();
    }

    @Override
    synchronized public void run() {

        Map.Entry<Long, Runnable> timestampRunnableEntry = treeMap.pollFirstEntry();

        if (nonNull(timestampRunnableEntry)) {
            executeTask(timestampRunnableEntry);
            System.out.println("My task done " + Thread.currentThread());
        }

    }

    private void executeTask(Map.Entry<Long, Runnable> timestampRunnableEntry) {

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                new Thread(timestampRunnableEntry.getValue()).run();
            }
        };


        Timer timer = new Timer();
        timer.schedule(task, timestampRunnableEntry.getKey());
    }
}
