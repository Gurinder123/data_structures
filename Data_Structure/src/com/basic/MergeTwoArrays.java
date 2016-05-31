package com.basic;

/**
 * Created by gurinder on 31/5/16.
 */
public class MergeTwoArrays {

    public static void main(String[] args) {
        int a[] = {10, 1, 2, 3, 4, 7};
        int b[] = {5, 6, 2, 3, 4};
        int[] c = new int[a.length + b.length];

        int i = 0, j = 0, k = 0;
        while (i < a.length || j < b.length) {
            if (i < a.length)
                c[k++] = a[i++];
            else
                c[k++] = b[j++];
        }
        int temp = 0;
        for (i = 0; i < c.length; i++) {
            for (j = i + 1; j < c.length; j++) {
                if (c[i] > c[j]) {
                    temp = c[i];
                    c[i] = c[j];
                    c[j] = temp;
                }
                if (c[i] == c[j])
                    c[j] = -1;
            }
        }

        for (int val : c)
            if (val != -1)
                System.out.print(val + " ");
    }
}
