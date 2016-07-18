package com.basic.sortings;

/**
 * Created by gurinder on 18/7/16.
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] a = {2, 1, 11, 3, 4, 8, 19, 1, 2, 45, 7};
        int temp = 0, min = 0;
        for (int i = 0; i < a.length; i++) {
            min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
        for (int i : a)
            System.out.print(i + " ");
    }
}
