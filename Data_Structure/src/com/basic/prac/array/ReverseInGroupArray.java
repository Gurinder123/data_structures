package com.prac.array;

public class ReverseInGroupArray {

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};

        int k = 3;

        int len = arr.length;

        reverse(arr, len - 1, k);

        for (int i = 0; i < len; i++)
            System.out.print(arr[i] + " ");
    }

    private static void reverse(int[] arr, int len, int k) {

        int count;

        for (int i = 0; i < len; i = i + k) {

            int left = i;
            int right = Math.min(i + k - 1, len);

            for (int j = Math.min(i + k - 1, len) ; j >= left; j--) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left += 1;
                right -= 1;
            }

        }
    }
}
