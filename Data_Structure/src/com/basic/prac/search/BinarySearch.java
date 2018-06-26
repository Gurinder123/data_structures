package com.prac.search;

public class BinarySearch {

    public static void main(String[] args) {

        int a[] = {1, 2, 3, 4, 5, 6, 7};
        int i = 0, j = a.length - 1, mid;

        int element = 5;

        while (i <= j) {
            mid = (i + j) / 2;

            if (a[mid] == element) {
                System.out.println("Index : " + i);
                break;
            }
            if (a[mid] < element) {
                i = mid + 1;
            } else if (a[mid] > element) {
                j = mid - 1;
            }


            j--;
        }
    }

}
