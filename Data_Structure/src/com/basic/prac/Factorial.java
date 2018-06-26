package com.prac;

public class Factorial {
    public static void main(String[] args) {
        int n = fact(6);

        System.out.println(n);
    }

    private static int fact(int val) {
        if (val <= 1)
            return 1;

        return fact(val - 1) * val;
    }
}
