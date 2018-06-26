package com.prac;

public class Fibonacci {

    public static void main(String[] args) {

        int number = Integer.parseInt(args[0]);

        for (int i = 0; i <= number; i++) {
            int result = fib(i);
            if (result <= number)
                System.out.print(result + " ");
            else
                break;
        }
    }

    private static int fib(int val) {
        if (val == 0 || val == 1)
            return 1;

        return fib(val - 1) + fib(val - 2);
    }
}


