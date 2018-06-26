package com.prac.array;

public class TowerOfHanoi {

    public static void main(String[] args) {

        towerOfHanoi(3, 'a', 'c', 'b');
    }

    private static void towerOfHanoi(int n, char a, char c, char b) {

        if (n == 1) {
            System.out.println("Moving from " + a + " to " + c);
            return;
        }

        towerOfHanoi(n - 1, a, b, c);

        System.out.println("Moving from " + a + " to " + c);

        towerOfHanoi(n - 1, b, c, a);
    }
}
