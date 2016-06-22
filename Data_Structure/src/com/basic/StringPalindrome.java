package com.basic;

/**
 * Created by gurinder on 1/6/16.
 */
public class StringPalindrome {
    public static void main(String[] args) {
        String s = "NitiN";
        char[] c = s.toCharArray();
        int i = 0, j = c.length - 1;
        boolean flag = true;
        while (i < c.length) {
            if (c[i] != c[j--])
                flag = false;
            i++;
        }
        if (flag)
            System.out.println("Palindrome");
        else
            System.out.println("Not a Palindrome");
    }

}
