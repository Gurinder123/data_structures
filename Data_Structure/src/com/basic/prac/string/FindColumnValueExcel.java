package com.prac.string;

//Input          Output
//        26             Z
//        51             AY
//        52             AZ
//        80             CB
//        676            YZ
//        702            ZZ
//        705            AAC

public class FindColumnValueExcel {

    public static void main(String[] args) {

        int number = 705;

        StringBuilder builder = new StringBuilder();

        while (number > 0) {

            int rem = number % 26;

            if (rem == 0) {
                builder.append('Z');
                number = (number / 26) - 1;
            } else {
               builder.append((char)((rem - 1) + 'A'));
               number = number / 26;
            }
        }

        System.out.println(builder.reverse());
    }
}
