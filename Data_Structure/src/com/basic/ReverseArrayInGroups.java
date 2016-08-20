package com.basic;

import java.util.Scanner;

/**
 * Created by Gurinder on 8/20/2016.
 *  Program to reverse array in group example arr ={1,2,3,4,5,6,7,8,9}
 *  input = 3
 *  output= [3 2 1 6 5 4 9 8 7 10]
 */

public class ReverseArrayInGroups {
    static int count = 0;
    static int start = 0;

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Scanner scan = new Scanner(System.in);
        int end = scan.nextInt();
        int copyArr[] = new int[arr.length];
        if (end != 1) {
            while (true) {
                boolean flag = reverse(arr, (start + end) - 1, copyArr);
                if (!flag)
                    break;
            }
        } else
            copyArr = arr;
        for (int i : copyArr)
            System.out.print(i + " ");
    }

    private static boolean reverse(int[] arr, int end, int[] copyArr) {
        int copyEnd = end;
        boolean flag = false;
        while (start <= end && arr.length >= end) {
            copyArr[count++] = arr[end--];
            flag = true;
        }
        if (!flag) {
            for (; start < arr.length; start++)
                copyArr[count++] = arr[start];
        }
        start = copyEnd + 1;
        return flag;
    }


}
