package com.basic;

/**
 * Created by gurinder on 1/6/16.
 *
 *  Remove the given character from a string
 */
public class RemoveGivenCharInString {
    public static void main(String[] args) {
        String str = "Gurinder";
        char c[] = str.toCharArray();
        str = removeChar(c, 'r', str);
        System.out.println(str);
    }

    private static String removeChar(char[] c, char r, String string) {
        int pos = 0;
        for (char val : c) {
            if (val == r)
                break;

            pos++;
        }
        return new StringBuilder(string).deleteCharAt(pos).toString();
    }
}
