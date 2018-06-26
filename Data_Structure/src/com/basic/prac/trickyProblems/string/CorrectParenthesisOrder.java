package com.prac.trickyProblems.string;

import java.util.Scanner;
import java.util.Stack;

public class CorrectParenthesisOrder {

    private static int countCurly;
    private static int countSqr;
    private static int countBrackets;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) == '{' || input.charAt(i) == '[' || input.charAt(i) == '(') {
                stack.push(input.charAt(i));
            } else if (input.charAt(i) == '}' || input.charAt(i) == ']' || input.charAt(i) == ')') {
                Character pop = stack.pop();

                if (!validate(pop, input.charAt(i))) {
                    System.out.println("Unbalanced");
                    break;
                }
            }

        }


        System.out.println("\n Second way :");

        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) == '{' || input.charAt(i) == '}')
                countCurly++;
            if (input.charAt(i) == '[' || input.charAt(i) == ']')
                countSqr++;
            if (input.charAt(i) == '(' || input.charAt(i) == ')')
                countBrackets++;

        }

        if ((countSqr + countBrackets + countCurly) % 2 == 0)
            System.out.println("Balanced");
        else
            System.out.println("Un Balanced");


    }

    private static boolean validate(Character c1, char c2) {

        if (c1 == '{' && c2 == '}')
            return true;
        if (c1 == '(' && c2 == ')')
            return true;
        if (c1 == '[' && c2 == ']')
            return true;

        return false;
    }
}
