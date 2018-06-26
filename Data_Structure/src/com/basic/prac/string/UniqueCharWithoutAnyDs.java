package com.prac.string;

public class UniqueCharWithoutAnyDs {

    public static void main(String[] args) {
        String str = "abc";

        fudduSolution(str);

        System.out.println("unique string ascii: "+asciiValueSolution(str));
        System.out.println("unique string operators: "+isUniqueChars(str));

    }

    private static boolean asciiValueSolution(String str) {
        boolean[] asciiValue = new boolean[128];

        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i);
            if (asciiValue[c])
                return false;

            asciiValue[c] = true;
        }

        return true;
    }

    private static void fudduSolution(String str) {
        char[] chars = str.toCharArray();

        BreakOuter:
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    System.out.println("duplicate: " + chars[i]);
                    break BreakOuter;
                }
            }
        }
    }

    public static boolean isUniqueChars(String str) {

        int checker = 0;

        for (int i = 0; i < str.length(); ++i) {
            int val = str.charAt(i);

            if ((checker & (1 << val)) > 0)
                return false;

            checker = (1 << val);
        }

        return true;
    }
}
