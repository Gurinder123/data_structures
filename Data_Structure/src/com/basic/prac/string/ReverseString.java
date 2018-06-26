package com.prac.string;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        String str = "gurinder";

        int start = 0;
        int end = str.length() - 1;

        char[] chars = str.toCharArray();
        while (start < end) {
            char temp = chars[end];
            chars[end] = chars[start];
            chars[start] = temp;
            end--;
            start++;
        }

        str = new String(chars);

        System.out.println(str);

        char[] str1 = str.concat(" singh").toCharArray();
//        ReplaceFun(str1, str1.length - 1);

        int a[] = {1,2,3,4,5};
        int begin =0 , last = a.length -1, mid =0;

        while(last > 0){

            mid = (begin + last) / 2;
            if (a[mid] == 4) {
                System.out.println(a[mid]);
                break;
            }
            if (a[mid] > 4)
                last = mid - 1;
            else
                begin = mid + 1;
        }

    }

    public static void ReplaceFun(char[] str, int length) {

        int spaceCount = 0, newLength, i = 0;

        for (i = 0; i < length; i++) {


            if (str[i] == ' ') {
                spaceCount++;
            }
        }

        newLength = length + spaceCount * 2;

        for (i = length - 1; i >= 0; i--) {


            if (str[i] == ' ') {

                str[newLength - 1] = '0';
                str[newLength - 2] = '2';
                str[newLength - 3] = '%';


                newLength = newLength - 3;


            } else {
                str[newLength - 1] = str[i];
                newLength = newLength - 1;
            }
        }

        for (char c : str) {
            System.out.println(c);
        }
    }
}
