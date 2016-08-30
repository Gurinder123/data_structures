package com.basic;

/**
 * Created by gurinder on 27/8/16.
 */
public class NumberToBinary {
    public static void main(String[] args) {
        String binary = "";
        int a = 25;
        while (a > 0) {
            binary += a % 2;
            a = a / 2;
        }
        char ch[] = binary.toCharArray();
        int max = 0;
        int count = 0;

        for (int i = ch.length - 1; i >= 0; i--) {
            if (ch[i] - 48 == 0)
                count++;
            else {
                if (max < count)
                    max = count;
            }
        }
        System.out.println("max zero: " + max);
    }
}
