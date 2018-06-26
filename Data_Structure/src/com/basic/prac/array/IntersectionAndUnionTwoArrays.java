package com.prac.array;

import java.util.HashSet;

public class IntersectionAndUnionTwoArrays {
    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 4, 5};
        int arr2[] = {6, 7, 8, 3, 5};

        System.out.println("Union:");

        HashSet set = new HashSet();

        for (int val : arr1) {
            set.add(val);
            System.out.print(val+" ");
        }

        for (int val : arr2) {
            if (!set.contains(val)){
                System.out.print(val+" ");
            }
        }


        System.out.println("\nIntersection:");

        for (int val : arr2) {
            if (set.contains(val)){
                System.out.print(val+" ");
            }
        }

    }
}
