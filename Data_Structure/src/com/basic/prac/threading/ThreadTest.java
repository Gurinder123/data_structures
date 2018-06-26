package com.prac.threading;


import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest extends Thread {

    private int count = 0;

    private static ReentrantLock reentrantLock = new ReentrantLock(true);

    @Override
    synchronized public void run() {
        System.out.println("Run method called " + (++count));
    }

    enum Bands {
        Metallica, Megadeth, Slayer
    }

    private static List<String> stringList = new ArrayList<>();

    void method(){
        synchronized (stringList){
            stringList.add("something");
            System.out.println(stringList.hashCode() +" mera part 1");
            stringList = new ArrayList<>();
            System.out.println(stringList.hashCode()+" mera part 2");
            System.out.println("New wala");
        }
    }
    public static void main(String[] args) throws Exception {

        Comparator<String> myComparator = Comparator.comparing((s1) -> s1.length(), Comparator.reverseOrder());

        TreeSet<String> set = new TreeSet(myComparator);

        set.add("Ankit");
        set.add("A");
        set.add("Guri");
        set.add("Gurinder");

        System.out.println(set);

        ThreadTest test = new ThreadTest();
        test.method();
        List<String> strings = Arrays.asList("Gurinder", "Singh");
        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5);

        Integer sumOfString = strings.parallelStream().reduce(100, (l1, l2) -> l1 + l2.length(), (c1, c2) -> c1 + c2);

        Integer sumOfInteger = number.parallelStream().reduce(100, (l1, l2) -> l1-l2);


        System.out.println(sumOfString);
        System.out.println(sumOfInteger);

        EnumMap<Bands, String> enumMap = new EnumMap(Bands.class);

        enumMap.put(Bands.Megadeth, "My Favourite band");
        enumMap.put(Bands.Metallica, "My Favourite band");
        enumMap.put(Bands.Slayer, "My Favourite band");


        System.out.println(enumMap);
        Bands band = enumMap.entrySet().stream().map(Map.Entry::getKey).reduce(Bands.Megadeth, (b1, b2) -> b2 == b1 ? Bands.Megadeth : Bands.Slayer);

        System.out.println(band);

        reentrantLock.lock();
        try {
            ExecutorService executor = Executors.newScheduledThreadPool(5);

            Future<String> futures[] = new Future[5];

            for (int i = 0; i < 5; i++) {
                futures[i] = executor.submit(() -> {

                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Done");

                    return "I am done";
                });
            }


            for (int i = 0; i < 5; i++) {
                while (true) {
                    Thread.sleep(1000);
                    if (futures[i].isDone()) {
                        System.out.println("Ho gya " + i + " " + futures[i].get());
                        break;
                    } else {
                        System.out.println("Abhi bhi nahi hua " + i);
                    }

                }
            }
        } finally {
            System.out.println("Releasing lock");
            System.out.println(reentrantLock.isFair());
            reentrantLock.unlock();

        }
    }
}

