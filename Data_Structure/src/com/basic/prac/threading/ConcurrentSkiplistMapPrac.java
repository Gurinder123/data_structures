package com.prac.threading;

import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkiplistMapPrac {

    public static void main(String[] args) {

        ConcurrentSkipListMap<PerfectlyImmutable, String> listMap = new ConcurrentSkipListMap<>();

        listMap.put(new PerfectlyImmutable("Gurinder", "Singh", 1), "First");
        listMap.put(new PerfectlyImmutable("Gurinder", "Singh", 1), "First");

    }
}
