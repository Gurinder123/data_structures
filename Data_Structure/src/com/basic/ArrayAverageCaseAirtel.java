package com.basic;

/**
 * Created by gurinder on 6/6/16.
 */
public class ArrayAverageCaseAirtel {
    private static int a[];
    private static int b[];

    public static void main(String[] args) {
        int[] array = {0, 2, 1, 5, 7, 9};
        int length = array.length / 2;
        a = new int[length];
        b = new int[length];
        makeCombination(array, 0, array.length - 1);
    }

    private static void makeCombination(int[] ary, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            checkAverage(ary, ary.length / 2);
        } else {
            for (int i = startIndex; i <= endIndex; i++) {
                swap(ary, startIndex, i);
                makeCombination(ary, startIndex + 1, endIndex);
                swap(ary, startIndex, i);
            }
        }
    }

    private static void checkAverage(int[] ary, int p) {
        int average1 = 0, average2 = 0;
        int j = 0, k = 0;
        for (int i = 0; i < ary.length; i++) {
            if (i < p) {
                average1 += ary[i];
                a[j++] = ary[i];
            } else {
                average2 += ary[i];
                b[k++] = ary[i];
            }
        }
        if ((average1 / p) == (average2 / p)) {
            System.out.print("Array1:[");
            for (int a1 : a)
                System.out.print(a1 + " ");
            System.out.print("\b]");
            System.out.println();
            System.out.print("Array2:[");
            for (int b1 : b)
                System.out.print(b1 + " ");
            System.out.print("\b]");
            System.out.println();
        }

    }

    public static void swap(int[] ary, int x, int y) {
        int temp = ary[x];
        ary[x] = ary[y];
        ary[y] = temp;
    }
}
