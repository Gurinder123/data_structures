package com.prac.string;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class DifferentDate {
    public static void main(String[] args) {
        String str = "12-01-1990 and some more words with date 12-12-2017 and again some random words with same date 12-05-1990";
        String[] splitArray = str.split(" ");

        HashMap<String , String> dateHashMap = new HashMap<>();
        for (String string : splitArray) {
            if (string.contains("-")) {
                String[] date = string.split("-");
                dateHashMap.put(date[2], string);
            }
        }

        System.out.println(dateHashMap);
    }
}
