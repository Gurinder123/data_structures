package com.prac.string;

public class RemoveDuplicateWithOutBuffer {

    public static void main(String[] args) {
        String str = "abcd";
        removeDuplicate(str.toCharArray());
        str = "aaaa";
        removeDuplicate(str.toCharArray());
        str = "";
        removeDuplicate(str.toCharArray());
        str = "aaabbb";
        removeDuplicate(str.toCharArray());
        str = "abababa";
        removeDuplicate(str.toCharArray());
    }

    public static void removeDuplicate(char[] chars) {
        if (chars == null)
            return;

        int length = chars.length;

        if (length < 2)
            return;


        for (int i = 0; i < length; i++) {
            int j;

            for (j = i + 1; j < length; j++) {
                if (chars[i] == chars[j]) {
                    chars[i] = 0;
                    break;
                }
            }
        }

        for (char c : chars) {
            if (c != 0)
                System.out.print(c + " ");
        }
        System.out.println();
    }
}
