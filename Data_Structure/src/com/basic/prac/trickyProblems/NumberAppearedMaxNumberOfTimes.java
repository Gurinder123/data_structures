package com.prac.trickyProblems;

import java.util.function.Function;
import java.util.function.Supplier;

public class NumberAppearedMaxNumberOfTimes {

    public static void main(String[] args) {

        int temp = 5;

        Function<Integer, Boolean> isTrue = (i) -> compute(i);

        if (temp > 7 && isTrue.apply(4) == true) {
            System.out.println("Path 1");
        } else {
            System.out.println("Path 2");
        }
    }

    private static boolean compute(Integer i) {
        System.out.println("Compute called");
        return i > 7;
    }
}