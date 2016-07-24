package com.basic;

/**
 * Created by gurinder on 24/7/16.
 */
public class FindMoreThanOneMissingNumber {
    public static void main(String[] args) {
        int a[] = {2, 3, 4, 9, 10, 11, 12, 5, 6, 8};
        sort(a);
        int count = 1;
        for (int v = 0; v < a.length; ) {
            if (count != a[v]) {
                System.out.println("Missing number is " + count);
                count++;
            } else {
                count++;
                v++;
            }
        }

    }

    private static void sort(int[] a) {
        int min, j, temp = 0;
        for (int i = 1; i < a.length; i++) {
            min = a[i];
            j = i - 1;
            while (j >= 0 && min < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = min;
        }
    }
}
