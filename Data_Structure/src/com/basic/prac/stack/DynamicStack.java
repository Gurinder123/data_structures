package com.prac.stack;


import java.util.Arrays;
import java.util.EmptyStackException;

public class DynamicStack<T> {

    private Object[] data;
    private int top = -1;
    private int capacity;

    public DynamicStack() {
        capacity = 5;
        data = new Object[capacity];
    }

    public static void main(String[] args) {

        DynamicStack<Integer> stack = new DynamicStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        stack.pop();

        System.out.println(stack);
    }

    public T pop() {
        if (isEmpty())
            throw new EmptyStackException();

        Object element = data[top];
        data[top] = null; /* to let gc do its work */
        --top;

        return (T) element;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(T e) {
        if (isFull())
            reSize();

        data[++top] = e;
    }

    private void reSize() {
        capacity = capacity * 2;
        data = Arrays.copyOf(data, capacity);
    }

    private boolean isFull() {
        return top == capacity - 1;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append("[");

        if (top == -1)
            return builder.append(']').toString();

        for (int i = 0; i < data.length; i++) {

            if (data[i] != null)
                builder.append(data[i]);
            else break;

            builder.append(',').append(' ');
        }

        return builder.append(']').toString();
    }
}
