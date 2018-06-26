package com.prac.array;

public class FindElementInSorted2dArray {

    public static void main(String[] args) {
        int mat[][] = {{10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}};

        search(mat, 4, 37);
    }

    private static void search(int[][] mat, int size, int element) {

        int i = 0;
        int j = size - 1;

        while (i < size && j >= 0) {

            if (mat[i][j] == element)
                System.out.println("Position : " + i + "," + j);

            if (mat[i][j] > element)
                j--;
            else
                i++;
        }

    }
}
