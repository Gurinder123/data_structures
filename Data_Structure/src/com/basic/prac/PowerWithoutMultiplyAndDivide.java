package com.prac;

public class PowerWithoutMultiplyAndDivide {
    public static void main(String[] args) {
        int val = 5, power = 4              ;

        int temp = val;
        for (int i = 1; i < power; i++) {
            for (int j = 1; j < temp; j++) {
                val += temp;
            }
           temp = val;
        }

        System.out.println(val);
    }
}
