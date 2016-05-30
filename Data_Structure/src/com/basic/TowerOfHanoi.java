package com.basic;

import java.util.Scanner;

/**
 * Created by gurinder on 30/5/16.
 */
public class TowerOfHanoi {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfRings = input.nextInt();

        createTower(numberOfRings, 'A', 'B', 'C');
    }

    private static void createTower(int numberOfRings, char from, char aux, char to) {
        if (numberOfRings == 1)
            System.out.println(numberOfRings + " disk " + from + " " + to);
        else {
            createTower(numberOfRings - 1, from, to, aux);
            System.out.println(numberOfRings + " disk " + from + " " + to);
            createTower(numberOfRings - 1, aux, from, to);
        }
    }
}
