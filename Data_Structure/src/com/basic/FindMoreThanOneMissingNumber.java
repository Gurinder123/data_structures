package com.basic;

import com.basic.sortings.InserionSort;

/**
 * Created by gurinder on 24/7/16.
 *
 * find if there is more than number are missing
 */
public class FindMoreThanOneMissingNumber {
    public static void main(String[] args) {
        int a[] = {2, 3, 4, 9, 10, 11, 12, 5, 6, 8};
        InserionSort.sort(a);

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

}
