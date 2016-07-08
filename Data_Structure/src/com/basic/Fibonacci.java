package com.basic;

/**
 * Created by Gurinder on 6/17/2016.
 */
public class Fibonacci {
    public static void main(String[] args) {
        for (int i = 1; i <= 6; i++) {
            System.out.print(fib(i));
            System.out.print(" ");
        }
    }

    private static int fib(int i) {
        if (i == 0)
            return 0;
        if (i == 1)
            return 1;

        return fib(i - 1) + fib(i - 2);
    }
}
