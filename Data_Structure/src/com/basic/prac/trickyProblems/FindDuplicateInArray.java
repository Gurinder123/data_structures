package com.prac.trickyProblems;

import java.time.Duration;
import java.util.Arrays;

public class FindDuplicateInArray {
    public static void main(String[] args) {

        int a[] = {3, 2, 1, 2, 2, 3};

//        for (int i = 0; i < a.length; i++) {
//
//            if (a[Math.abs(a[i])] >= 0)
//                a[Math.abs(a[i])] = -a[Math.abs(a[i])];
//            else
////                System.out.print(Math.abs(a[i]) + " ");
//        }

        int arr[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        printSpirally(arr);

    }

    private static void printSpirally(int[][] arr) {

        Duration.ofSeconds(1);

        int start = 0;
        int end = arr.length;

        int columnStart = 0;
        int rowEnd = arr.length;

        int columnLast = arr.length;
        int rowStart = 0;

        while (start < end) {

            // print upper row
            for (int i = 0 ; i < columnLast ; i++){
                System.out.print(arr[rowStart][i] + " ");
            }

            rowStart++;

            // print last column
            for (int i = rowStart ; i <  columnLast; i++){
                System.out.print(arr[i][columnLast - 1] + " ");
            }

            columnLast --;

            // print lower row
            for (int i = columnLast - 1 ; i >=  columnStart; i--){
                System.out.print(arr[rowEnd - 1][i] + " ");
            }

            rowEnd -- ;

        }

    }
}
// 00 01 02
// 10 11 12
// 20 21 22
