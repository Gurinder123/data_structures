package com.basic.sortings;

/**
 * Created by gurinder on 18/7/16.
 */
public class InserionSort {
    public static void main(String[] args) {
        int[] a = {2, 1, 11, 3, 4, 8, 19, 1, 2, 45, 7};
        int temp = 0, j, key;
        for (int i = 1; i < a.length; i++) {
            key = a[i];
            j = i - 1;
            while (j >= 0 && key < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
        for (int i : a)
            System.out.print(i + " ");
    }
}

