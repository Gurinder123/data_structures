package com.basic;

/**
 * Created by Gurinder on 6/17/2016.
 */
public class Factorial {
    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            System.out.print(fact(i));
            System.out.print(" ");
        }
    }

    private static int fact(int i) {
        if (i == 0 || i == 1)
            return 1;

        return fact(i - 1) * i;
    }
}
