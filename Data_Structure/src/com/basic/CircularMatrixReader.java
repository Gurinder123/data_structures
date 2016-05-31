package com.basic;

/**
 * Created by gurinder on 31/5/16.
 */
public class CircularMatrixReader {
    public static void main(String[] args) {
        int[][] n = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println("Actual matrix");
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n.length; j++) {
                System.out.print(n[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Circularmatrix");

        spiralPrint(4, 4, n);
    }

    static void spiralPrint(int m, int n, int a[][]) {
        int i, k = 0, l = 0;

    /*  k - starting row index
        m - ending row index
        l - starting column index
        n - ending column index
        i - iterator
    */

        while (k < m && l < n) {
        /* Print the first row from the remaining rows */
            for (i = l; i < n; ++i) {
                System.out.print(a[k][i]+" ");
            }
            k++;

        /* Print the last column from the remaining columns */
            for (i = k; i < m; ++i) {
                System.out.print(a[i][n - 1]+" ");
            }
            n--;

        /* Print the last row from the remaining rows */
            if (k < m) {
                for (i = n - 1; i >= l; --i) {
                    System.out.print(a[m - 1][i] + " ");
                }
                m--;
            }

        /* Print the first column from the remaining columns */
            if (l < n) {
                for (i = m - 1; i >= k; --i) {
                    System.out.println(a[i][l] + " ");
                }
                l++;
            }
        }
    }
}
