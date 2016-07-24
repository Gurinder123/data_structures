package com.basic.sortings;

/**
 * Created by gurinder on 18/7/16.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {2, 1, 11, 3, 4, 8, 19, 1, 2, 45, 7};
        quicksort(a, 0, a.length - 1);

        for (int val : a)
            System.out.print(val + " ");

    }

    public static void quicksort(int[] a, int p, int r) {
        if (p < r) {
            int q = partition(a, p, r);
            quicksort(a, p, q - 1);
            quicksort(a, q + 1, r);
        }
    }

    private static int partition(int[] a, int p, int r) {
        int i, j, pivot, temp;
        pivot = a[p];
        i = p;
        j = r;
        while (i < j) {
            while (a[i] <= pivot && i < j)
                i++;
            while (a[j] > pivot)
                j--;
            if (i < j) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        return j;
    }
}
