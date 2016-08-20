package com.basic;

/**
 * Created by gurinder on 8/6/16.
 *  Binary search
 */
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 3, 4, 5, 6, 7};
        int start = 0;
        int last = arr.length;
        int middle = 0;
        int element = 3;
        while (start < last) {
            middle = (start + last) / 2;

            if (arr[middle] > element)
                last = last - 1;
            else
                start = start + 1;

            if (arr[middle] == element) {
                System.out.println("on index: " + middle);
                break;
            }

        }
    }
}
