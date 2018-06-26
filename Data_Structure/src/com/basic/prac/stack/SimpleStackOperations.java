package com.prac.stack;


public class SimpleStackOperations {

    private int stack[] = new int[10];

    int top = -1;


    public static void main(String[] args) {

        SimpleStackOperations element = new SimpleStackOperations();
        element.push(2);
        element.push(5);
        element.push(1);
        element.push(4);
        element.pop();

        element.print();
        element.pop();
        element.print();
    }

    private void pop() {
        if (isEmpty())
            System.out.println("Stack Is Empty");
        else
            stack[top--] = 0;
    }

    private void print() {
        if (isEmpty())
            System.out.println("Stack Is Empty");
        else {
            System.out.println("\nStack Elements");
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
    }


    private void push(int data) {
        if (isFull()) {
            System.out.println("Stack is Full");
        } else {
            stack[++top] = data;
        }
    }

    private boolean isFull() {
        return top == (stack.length - 1);
    }

    private boolean isEmpty() {
        return top == -1;
    }
}
