package com.prac;

public class PrimeNumberUptoN {
    public static void main(String[] args) {
        int n = 100;
        System.out.print(2 + " ");
        for (int i = 3; i < n; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0)
                    isPrime = false;
            }

            if (isPrime)
                System.out.print(i + " ");
        }
    }
}
