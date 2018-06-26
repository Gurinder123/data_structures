package com.prac.array;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class NumberToBinary {

    public static void main(String[] args) {
        int num = 6;

        StringBuilder builder = new StringBuilder();

        while (num > 0) {
            builder.append(num % 2);
            num = num / 2;
        }

        System.out.println(builder.reverse());

        Map<String, String> map = new HashMap();

    }
}
