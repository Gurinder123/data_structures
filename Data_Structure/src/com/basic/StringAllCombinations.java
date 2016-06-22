package com.basic;

/**
 * Created by gurinder on 1/6/16.
 */
public class StringAllCombinations {
    public static void main(String[] args) {
        String s = "CAT";
        permute(s.toCharArray(), 0, s.length() - 1);
    }

    private static void permute(char[] ary, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            System.out.println(String.valueOf(ary));
        } else {
            for (int i = startIndex; i <= endIndex; i++) {
                swap(ary, startIndex, i);
                permute(ary, startIndex + 1, endIndex);
                swap(ary, startIndex, i);
            }
        }
    }

    public static void swap(char[] ary, int x, int y) {
        char temp = ary[x];
        ary[x] = ary[y];
        ary[y] = temp;
    }
}
