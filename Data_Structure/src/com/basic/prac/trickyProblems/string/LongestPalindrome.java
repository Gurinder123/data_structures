package com.prac.trickyProblems.string;

import java.util.*;

public class LongestPalindrome {


    Stack<Integer> s;
    Integer minEle;

    // Constructor
    LongestPalindrome() {
        s = new Stack<Integer>();
    }

    // Prints minimum element of LongestPalindrome
    void getMin() {
        // Get the minimum number in the entire stack
        if (s.isEmpty())
            System.out.println("Stack is empty");

            // variable minEle stores the minimum element
            // in the stack.
        else
            System.out.println("Minimum Element in the " +
                    " stack is: " + minEle);
    }

    // prints top element of LongestPalindrome
    void peek() {
        if (s.isEmpty()) {
            System.out.println("Stack is empty ");
            return;
        }

        Integer t = s.peek(); // Top element.

        System.out.print("Top Most Element is: ");

        // If t < minEle means minEle stores
        // value of t.
        if (t < minEle)
            System.out.println(minEle);
        else
            System.out.println(t);
    }

    // Removes the top element from LongestPalindrome
    void pop() {
        if (s.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }

        System.out.print("Top Most Element Removed: ");
        Integer t = s.pop();

        // Minimum will change as the minimum element
        // of the stack is being removed.
        if (t < minEle) {
            System.out.println(minEle);
            minEle = 2 * minEle - t;
        } else
            System.out.println(t);
    }

    // Insert new number into LongestPalindrome
    void push(Integer x) {
        if (s.isEmpty()) {
            minEle = x;
            s.push(x);
            System.out.println("Number Inserted: " + x);
            return;
        }

        // If new number is less than original minEle
        if (x < minEle) {
            s.push(2 * x - minEle);
            minEle = x;
        } else
            s.push(x);

        System.out.println("Number Inserted: " + x);
    }

    ;

    public static void main(String[] args) {

        int a[] = {1 , 1 , 3 , 5, 8, 10, 12, 14};

        int left = 0;
        int right = a.length - 1;

        while (left < right) {

            while (a[left] % 2 == 0 && left < right)
                left++;

            while (a[right] % 2 == 1 && left < right)
                right--;

            if (left < right) {
                /* Swap arr[left] and arr[right]*/
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
                right--;
            }
        }

        Arrays.stream(a).forEach(System.out::println);


    }


}
