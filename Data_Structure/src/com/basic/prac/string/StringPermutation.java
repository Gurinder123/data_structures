package com.prac.string;

import java.util.ArrayList;

public class StringPermutation {

    private static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {

        String pattern = "abbc";
        String str = "cbabadcbbabbcbacbab";

        permutation(pattern, 0, pattern.length() - 1);

        for (int i = 0; i < str.length() - 4; i++) {
            String substring = str.substring(i, i + 4);
            if (list.contains(substring))
                System.out.println(substring);
        }
    }

    private static void permutation(String str, int low, int high) {

        if (low == high)
            list.add(str);
        else {

            for (int i = low; i <= high; i++) {
                str = swap(str, low, i);
                permutation(str, low + 1, high);
                str = swap(str, low, i);
            }

        }
    }

    private static String swap(String str, int low, int high) {

        char[] chars = str.toCharArray();
        char temp;
        temp = chars[low];
        chars[low] = chars[high];
        chars[high] = temp;

        return String.copyValueOf(chars);
    }
}
