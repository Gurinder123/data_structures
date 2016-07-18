package com.basic.sortings;

/**
 * Created by gurinder on 18/7/16.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {2, 1, 11, 3, 4, 8, 19, 1, 2, 45, 7};
        int temp = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }
        for (int i : a)
            System.out.print(i + " ");
    }
}
