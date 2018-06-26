package com.prac;

import java.util.*;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.LongStream;

public class LinkedHashMapOperations extends LinkedHashMap {

    private int capacity;

    public LinkedHashMapOperations(int initialCapacity) {
        super(initialCapacity, 0.75f, true);
        this.capacity = initialCapacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {

        System.out.println(timeConversion("07:05:45PM"));
    }

    static String timeConversion(String s) {

        String[] time = s.split(":");

        StringBuilder builder = new StringBuilder();

        builder.append(Integer.parseInt(time[0]) + 12).append(":").append(time[1]).append(":").append(time[2].substring(0, time[2].length() - 2));

        return builder.toString();
    }
}