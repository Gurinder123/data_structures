package com.prac.trickyProblems;

public class MaxArraySumInArray {

    public static void main(String[] args) {

        int a[] = {-2, -1, 0, 1, 2, 3};

        int new_max_value = 0, max_value = Integer.MIN_VALUE;
        int start = 0, end = 0, s = 0;

        for (int i = 0; i < a.length; i++) {
            new_max_value += a[i];

            if (max_value < new_max_value) {
                max_value = new_max_value;
                start = s;
                end = i;
            }

            if (new_max_value < 0) {
                new_max_value = 0;
                s = i + 1;
            }
        }

        System.out.println(max_value);
        System.out.println("start: " + start + " end: " + end);
    }
}
