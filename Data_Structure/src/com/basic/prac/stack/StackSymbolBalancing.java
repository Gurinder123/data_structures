package com.prac.stack;

public class StackSymbolBalancing {

    private static DynamicStack stack = new DynamicStack();

    public static void main(String[] args) {

        String str = "[(A+B)+(C-D)]";

        System.out.println("is Balanced: " + isSymbolBalanced(str));
    }

    private static boolean isSymbolBalanced(String str) {

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) != ')' || str.charAt(i) == ']' || str.charAt(i) == '}') {
                stack.push(str.charAt(i));
            } else {

                boolean isBalance = checkBalance(str.charAt(i));

                if (!isBalance)
                    return false;
            }

        }

        while (!stack.isEmpty()){

            char remainingElements  = (char) stack.pop();

            if (remainingElements == '(' || remainingElements == '[' || remainingElements == '{')
                return false;

        }

        return true;
    }

    private static boolean checkBalance(char c) {

        char start = 0;

        if (c == ')') {
            start = '(';
        } else if(c == ']') {
            start = '[';
        } else if(c == '}') {
            start = '{';
        }

        char expected = 0;

        while(start != expected){
            expected = (char) stack.pop();
        }


        return expected == start;
    }

}
