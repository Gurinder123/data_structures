package com.basic;


/**
 * Created by gurinder on 31/5/16.
 */
public class SimpleDuplicateInArray {
    public static void main(String[] args) {
        int arr[] = {1, 6, 10, 2, 3, 1, 1, 2, 4, 5, 6, 7, 4, 10, 10};
        findDuplicate(arr, arr.length);
        System.out.println();
        for (int i : arr)
            System.out.print(i + " ");
    }

    private static void findDuplicate(int[] arr, int length) {
        int count;
        for (int i = 0; i < arr.length; i++) {
            count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j] && arr[j] > 0) {
                    arr[j] = -1;
                    count++;
                }
            }
            if (count > 1)
                System.out.print(arr[i] + " ");
        }
    }
}