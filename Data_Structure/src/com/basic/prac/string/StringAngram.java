package com.prac.string;

public class StringAngram {
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "siletn";

        // o(n) complexity
        System.out.println("Is anagaram: " + checkAnagram(str1, str2));

        str1 = "integral";
        str2 = "triangle";
        // o(n) complexity
        System.out.println("Is anagaram: " + checkAnagram(str1, str2));
    }


    private static boolean checkAnagram(String str1, String str2) {

        if (str1.length() != str2.length())
            return false;

        int length = 256;
        boolean b1[] = new boolean[length];

        for (char c : str1.toCharArray()) {
            b1[c] = true;

        }

        for (char c : str2.toCharArray()) {
            if (!b1[c]) {
                System.out.println("Not an anagram");
                return false;
            }
        }

        return true;
    }
}
