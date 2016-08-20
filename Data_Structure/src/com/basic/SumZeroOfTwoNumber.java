package com.basic;

/**
 * Created by Gurinder on 7/7/2016.
 *
 *  check first two numbers with sum zero
 */
public class SumZeroOfTwoNumber {


    public static void main(String[] args) {
        int a[] = {-3, -2, 1, 2, 2, 2, 2, 3, 4, 5};
        check(a, 0, a.length - 1);
    }

    private static void check(int[] a, int low, int high) {

        while (low <= high) {
            if (a[low] + a[high] == 0) {
                System.out.println("Numbers are: " + a[low] + " " + a[high]);
                return;
            } else if (a[low] + a[high] > 0) {
                high--;
            } else
                low++;
        }
    }
}
