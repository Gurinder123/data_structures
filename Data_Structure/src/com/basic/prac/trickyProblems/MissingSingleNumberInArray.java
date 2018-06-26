package com.prac.trickyProblems;

public class MissingSingleNumberInArray {
    public static void main(String[] args) {
        int a[] = {1, 2, 4, 5, 6, 7, 8, 9, 10};
        int len = a.length;

        int total = ((len + 1) * (len + 2)) / 2;

        for (int i = 0; i < a.length; i++)
            total -= a[i];

        System.out.println(total);

        findMissingXorWay(a);
    }

    static void findMissingXorWay(int a[]) {

        int x = 5, y = 8;

//        for (int i = 0; i < a.length; i++)
//            x = x ^ a[i];
//
//        for (int i = 1; i <= a.length; i++)
//            y = y ^ i;

        System.out.println((x ^ y));
    }
}
