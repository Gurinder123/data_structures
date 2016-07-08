package com.basic;

import java.util.Arrays;

/**
 * Created by Gurinder on 7/7/2016.
 */
public class ReverseWord {
    public static void main(String[] args) {
        String s = "My name is Gurinder Singh";
        s = reverseEveryThing(s.split(" "));
        System.out.println(s);
     }

    private static String reverseEveryThing(String[] split) {
        String[] copy = new String[split.length];
        int count = 0;
        for (int i = split.length - 1; i >= 0; i--) {
            String s = reverseWord(split[i]);
            copy[count++] =s;
        }
        return Arrays.toString(copy);
    }

    private static String reverseWord(String s) {
        char[] reverseWord = new char[s.length()];
        int i = s.length() - 1;
        for (char a : s.toCharArray()) {
            reverseWord[i--] = a;
        }
        return new String(reverseWord);
    }
}
