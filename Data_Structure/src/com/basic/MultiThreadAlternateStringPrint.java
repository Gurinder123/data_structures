package com.basic;

/**
 * Created by gurinder on 14/8/16.
 */
//        PrintMe me = new PrintMe();
//        Thread first = new Thread(new FirstNamePrinter(me));
//        Thread second = new Thread(new SecondNamePrinter(me));
//        first.start();
//        second.start();

public class MultiThreadAlternateStringPrint {
    public static void main(String[] args) {
        PrintMe me = new PrintMe();
        Thread elastic = new HelloWorld(me);
        elastic.start();
        Thread search = new HelloWorld(me);
        search.start();
    }

    private static class HelloWorld extends Thread {

        public HelloWorld(PrintMe me) {
            this.me = me;
        }

        PrintMe me;

        public void run() {
            while (true) {
                try {
                    me.printMe();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }


    }
}


class PrintMe {
    private static int count = 0;

    synchronized public void printMe() throws InterruptedException {
        if (count++ % 2 == 0) {
            System.out.println("Elastic");
            Thread.sleep(1000);
        } else {
            System.out.println("Search");
            Thread.sleep(1000);

        }
    }
}

