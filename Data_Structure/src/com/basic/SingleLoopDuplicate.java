package com.basic;

/**
 * Created by Gurinder on 7/8/2016.
 */
public class SingleLoopDuplicate {

    public static void main(String[] args) {
        int arr[] = {0, 1, 2, 3, 4, 6, 6, 16, 26, 26};
        int[] n = new int[arr.length];
        findDuplicates(arr, n, n.length);

    }

    private static void findDuplicates(int[] arr, int[] copy, int length) {
        for (int i = 0; i < length; i++) {
            int key = arr[i] % length;
            if (copy[key] == 0)
                copy[key] = arr[i];
            else {
                if (copy[key] != arr[i]) {
                    copy[key++] = arr[i];
                }
            }

        }
        for (int n : copy) {
            System.out.println(n);
        }
    }
}
