package com.prac.trickyProblems.string;

public class StringPermutation {

    public static void main(String[] args) {
        String str = "abc";
        permutation(str, 0, str.length() - 1);
    }

    private static void permutation(String str, int low, int high) {
        if (low == high)
            System.out.println(str);
        else {
            for (int i = 0; i < str.length(); i++) {
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
