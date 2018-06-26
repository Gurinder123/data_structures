package com.prac;

public class SmallRecursiveProblems {

    public static void main(String[] args) {

        int remainder = findRemainderWithoutModulus(15, 6);
        System.out.println(remainder);

        int n = power(2, 3);
        System.out.println(n);
    }

    private static int power(int val, int mul) {

        if (mul == 0)
            return 1;

        return power(val, mul -1) * val;
    }

    private static int findRemainderWithoutModulus(int number, int val) {
        int divNum = number / val;
        return number - (divNum * val);
    }
}
