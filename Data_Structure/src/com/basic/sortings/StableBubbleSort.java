package com.basic.sortings;

/**
 * Created by gurinder on 28/5/17.
 */
public class StableBubbleSort {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 5, 4, 6, 7};
        boolean swapped = true;
        for (int i = 0; i < a.length && swapped; i++) {
            swapped =false;
            for (int j = 0; j < a.length - i - 1; j++) {
                System.out.println(i+" "+j);
                if (
                        a[j] > a[j + 1]) {
                 int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                    swapped = true;
                }
            }
        }
        for (int i : a)
            System.out.print(i + " ");
    }
}
