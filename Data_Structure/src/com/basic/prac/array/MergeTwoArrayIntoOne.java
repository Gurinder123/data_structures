package com.prac.array;

import java.util.Objects;

public class MergeTwoArrayIntoOne {

    int a;
    byte b;
    long l;
    short s;
    double d;
    boolean bo;
    float f;

    @Override
     public boolean equals(Object o) {
        try {
            notify();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MergeTwoArrayIntoOne that = (MergeTwoArrayIntoOne) o;
        return a == that.a &&
                b == that.b &&
                l == that.l &&
                s == that.s &&
                Double.compare(that.d, d) == 0 &&
                b == that.b &&
                Float.compare(that.f, f) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, l, s, d, b, f);
    }

    public static void main(String[] args) {
       new MergeTwoArrayIntoOne().equals("");
        int a[] = {1, 2, 3, 4, 5};
        int b[] = {5, 6, 7, 8};

        int joinArray[] = mergeArraysWithDuplicate(a, b);
        for (int i : joinArray) {
            System.out.print(i + " ");
        }
        System.out.println();
        int joinArray2[] = mergeArraysWithOutDuplicate(a, b);
        for (int i : joinArray2) {
            if (i != 0)
                System.out.print(i + " ");
        }

    }

    private static int[] mergeArraysWithOutDuplicate(int[] a, int[] b) {
        int[] joinArrays = mergeArraysWithDuplicate(a, b);

        for (int i = 0; i < joinArrays.length; i++) {

            for (int j = i + 1; j < joinArrays.length; j++) {

                if (joinArrays[i] == joinArrays[j])
                    joinArrays[i] = 0;
            }

        }

        return joinArrays;
    }

    private static int[] mergeArraysWithDuplicate(int[] a, int[] b) {
        int[] joinArrays = new int[a.length + b.length];

        int count = 0;
        int i = 0, j = 0;
        while (count < a.length + b.length) {
            if (count < a.length)
                joinArrays[count++] = a[i++];
            else
                joinArrays[count++] = b[j++];
        }

        return joinArrays;
    }
}
