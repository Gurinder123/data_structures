package com.prac;


import java.util.*;

class A{
    void master(){
        System.out.println("Cha cha");
    }
}
public class StreamPractice extends A{

    void master(){
        System.out.println("Child");
    }

    public static void main(String[] args) {


        A a = new A();
        StreamPractice a1 = (StreamPractice) a;

        int i[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        String str[] = {"Gurinder", "Singh"};

        int reduceSeq = Arrays.stream(i).reduce(100, (i1, i2) -> i1 + i2);
        System.out.println(reduceSeq);

        int reduceParallel = Arrays.stream(i).parallel().reduce(100, (i1, i2) -> i1 + i2);
        System.out.println(reduceParallel);

        Map<Integer, Integer> map = new HashMap<>();

        map.put(1, 1);
        map.put(2, 1);
        map.put(3, 1);
        map.put(4, 1);
        map.put(5, 1);
        map.put(6, 1);
        map.put(7, 1);
        map.put(8, 1);
        map.put(9, 1);
        map.put(10, 1);
        map.put(11, 1);
        map.put(12, 1);
        map.put(13, 1);

        LinkedHashSet linkedList = new LinkedHashSet();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);

        Integer reduce = Arrays.asList(str)
                .stream()
                .reduce(0, (l1, l2) -> l1 + l2.length(),
                (c1, c2) -> c1 + c2);
        System.out.println(reduce);
    }

    void m1(){

    }
}
