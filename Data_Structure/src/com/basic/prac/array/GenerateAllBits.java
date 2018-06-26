package com.prac.array;

import java.util.Arrays;

public class GenerateAllBits {

    private static final int a[] = new int[3];

    public static void main(String[] args) {
        binary(2);
    }

    private static void binary(int n) {
        if (n < 1) {
            Arrays.stream(a).forEach(System.out::print);
            System.out.println();
        }else {
            a[n - 1] = 0;
            binary(n - 1);
            a[n - 1] = 1;
            binary(n - 1);
        }
    }
}
