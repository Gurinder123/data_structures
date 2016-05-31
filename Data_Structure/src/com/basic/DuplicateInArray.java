package com.basic;

import static java.lang.Math.abs;

public class DuplicateInArray {

    public static void main(String[] args) {
        int arr[] = {1, 6, 2, 3, 1, 2, 4, 5, 6, 7, 4};
        findDuplicate(arr, arr.length);
    }

    private static void findDuplicate(int[] arr, int length) {
        System.out.println("Duplicate elements are: ");
        for (int i = 0; i < length; i++) {
            if (arr[abs(arr[i])] >= 0)
                arr[abs(arr[i])] = -arr[abs(arr[i])];
            else
                System.out.print(abs(arr[i]) + " ");

        }
    }
}