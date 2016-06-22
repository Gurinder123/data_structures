package javacustoms;

/**
 * Created by gurinder on 22/6/16.
 */
public class Deadlock {
    public static void main(String[] args) {
        String s1 = "Gurinder";
        String s2 = "Singh";

        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized (s1) {
                    System.out.println("Thread 1: locked resource 1");

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (s2) {
                        System.out.println("Thread 1: locked resource 2");
                    }
                }
            }
        };
        t1.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                synchronized (s2)

                {
                    System.out.println("Thread 2: locked resource 2");

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (s1) {
                        System.out.println("Thread 2: locked resource 1");
                    }
                }
            }
        };
        t2.start();
    }
}