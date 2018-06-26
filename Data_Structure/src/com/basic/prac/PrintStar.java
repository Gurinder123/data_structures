package com.prac;


import sun.instrument.InstrumentationImpl;

import java.lang.instrument.Instrumentation;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PrintStar {

    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {

            for (int k = 1; k < i; k++)
                System.out.print(" ");

            for (int j = 5; j >= i; j--)
                System.out.print("* ");

            System.out.println();
        }

        for (int i = 1; i <= 5; i++) {

            for (int k = i; k < 5; k++)
                System.out.print(" ");


            for (int j = 0; j < i; j++)
                System.out.print("* ");


            System.out.println();
        }
    }


}

class GFG {
    // Function print matrix in spiral form
    static void spiralPrint(int rowEnd, int columnEnd, int a[][]) {
        int i, rowStart = 0, columnStart = 0;

        /*  rowStart - starting rowEnd index
        rowEnd - ending rowEnd index
        columnStart - starting columnEnd index
        columnEnd - ending columnEnd index
        i - iterator
        */

        while (rowStart < rowEnd && columnStart < columnEnd) {

            // Print the first rowEnd from the remaining rows
            for (i = columnStart; i < columnEnd; ++i) {
                System.out.print(a[rowStart][i] + " ");
            }
            rowStart++;

            // Print the last columnEnd from the remaining columns
            for (i = rowStart; i < rowEnd; ++i) {
                System.out.print(a[i][columnEnd - 1] + " ");
            }
            columnEnd--;

            // Print the last rowEnd from the remaining rows */
            if (rowStart < rowEnd) {
                for (i = columnEnd - 1; i >= columnStart; --i) {
                    System.out.print(a[rowEnd - 1][i] + " ");
                }
                rowEnd--;
            }

            // Print the first columnEnd from the remaining columns */
            if (columnStart < columnEnd) {
                for (i = rowEnd - 1; i >= rowStart; --i) {
                    System.out.print(a[i][columnStart] + " ");
                }
                columnStart++;
            }
        }
    }


    static void printSpirally2(int rowEnd, int columnEnd, int arr[][]) {

        int rowStart = 0;
        int columnStart = 0;
        int i = 0;

        while (rowStart < rowEnd && columnStart < columnEnd) {

            for (i = columnStart; i < columnEnd; i++)
                System.out.print(arr[columnStart][i] + " ");
            rowStart++;

            for (i = rowStart; i < rowEnd; i++)
                System.out.print(arr[i][columnEnd - 1] + " ");
            columnEnd--;

            if (rowStart < rowEnd) {

                for (i = columnEnd - 1; i >= columnStart; i--)
                    System.out.print(arr[rowEnd - 1][i] + " ");

                rowEnd--;
            }

            if (columnStart < columnEnd) {
                for (i = rowEnd - 1; i >= rowStart; i--)
                    System.out.print(arr[i][rowEnd - 1] + " ");

                columnStart++;
            }

        }
    }

// 00 01 02
// 10 11 12

    // driver program
    public  static void main(String[] args) throws ExecutionException, InterruptedException {


        double a, b,c;
        a = 3.0/0;
        b = 0/4.0;
        c=0/0.0;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        int R = 2;
        int C = 6;

//        printSpirally2(R, C, a);

        int w[] = {1, 2, 3, 21, 7, 12, 14, 21, 37, 97};

        int result = toys(w);

        System.out.println(result);

    }

    static int toys(int[] a) {

        Arrays.sort(a);
        int cost = 1;
        int p = a[0];

        for (int i = 0; i < a.length; i++) {
            if (a[i] > p + 4) {
                cost = cost + 1;
                p = a[i];
            }
        }

        return cost;
    }

}

interface master1{

}
