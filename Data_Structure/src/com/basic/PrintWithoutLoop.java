package com.basic;

/**
 * Created by gurinder on 30/4/17.
 */
public class PrintWithoutLoop {
    public static void main(String[] args) {
        printMe(10);
    }

    private static void printMe(int num) {
        if (num == 0)
            return;
        else
            System.out.println(num);
        printMe(num - 1);
    }
}
