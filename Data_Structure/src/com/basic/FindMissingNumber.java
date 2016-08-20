package com.basic;

/**
 * Created by gurinder on 24/7/16.
 *
 * find missing number in a normal sequence array
 *
 */
public class FindMissingNumber {
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12};
        int total = 0;
        int actualTotal = 1;
        int count = 2;
        for (int i : a) {
            actualTotal = actualTotal + count;
            count++;
            total = total + i;
        }
        System.out.println("Missing number is " + (actualTotal - total));
    }
}
