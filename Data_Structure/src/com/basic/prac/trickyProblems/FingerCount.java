package com.prac.trickyProblems;

public class FingerCount {

    public static void main(String[] args) {
        int sum = 10;

        int count = sum % 8;

            if (count == 1)
                System.out.println(count);

            if (count == 5)
                System.out.println(count);

            if (count == 0 || count == 2)
                System.out.println("Finger 2");

            if (count == 3 || count == 7)
                System.out.println("Finger 3");

            if (count == 4 || count == 6)
                System.out.println("Finger 4");

        }
    }
