package com.prac;


public class Practice {

    public static void main(String[] args) {

        int n = 2000;
        int pow = 0;

        System.out.println(isPowerOf2(n, pow));

        int initial = 1;
        boolean isPowerOf2 = false;
        while (initial < n) {
            initial = initial << 1;
            if (initial == n) {
                System.out.println("True it is");
                isPowerOf2 = true;
                break;
            }
        }

        if (!isPowerOf2)
            System.out.println("No its not");
    }

    private static boolean isPowerOf2(int num, int pow) {

        if (num < 2) {
            System.out.println("Power is " + pow);
            return true;
        }

        if (num % 2 == 1)
            return false;

        return isPowerOf2(num / 2, ++pow);
    }
}




