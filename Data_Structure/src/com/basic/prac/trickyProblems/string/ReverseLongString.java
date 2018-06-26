package com.prac.trickyProblems.string;

import java.util.Arrays;

public class ReverseLongString {

    public static void main(String[] args) {

        String str = "Gurinder Singh Panesar is an engineer I think so";

        String[] split = str.split(" ");

        int end = split.length - 1;

        for (int i = 0; i < split.length / 2; i++) {
            String temp = split[i];
            split[i] = split[end];
            split[end] = temp;
            end--;
        }

        Arrays.stream(split).forEach(element -> System.out.print(element + " "));


    }
}
