package com.prac.array.sorting;

import java.util.stream.IntStream;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = new int[]{5, 4, 3, 2, 1};

        quicksort(arr, 2, arr.length - 1);


        IntStream.of(arr).forEach(System.out::print);
    }

    private static void quicksort(int[] arr, int pivot, int size) {
        if (pivot < size) {
            int p = partition(arr, pivot, size);
            quicksort(arr, pivot, p-1);
            quicksort(arr, p + 1, size);
        }
    }

    private static int partition(int[] arr, int pivot, int size) {
        int val, temp, len, p;
        val = arr[pivot];
        p = pivot;
        len = size;

        while (arr[p] < val && arr[len] != val)
            len--;

        while (arr[p] > val && arr[len] != val)
            len++;

        if (p < len) {
            temp = arr[p];
            arr[p] = arr[len];
            arr[len] = temp;
        }

        return len;
    }
}
