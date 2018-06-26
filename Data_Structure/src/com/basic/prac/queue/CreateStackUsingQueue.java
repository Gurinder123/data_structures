package com.prac.queue;

import java.util.LinkedList;
import java.util.Queue;

public class CreateStackUsingQueue {

    Queue queue1 = new LinkedList();
    Queue queue2 = new LinkedList();

    public static void main(String[] args) {

        CreateStackUsingQueue stack = new CreateStackUsingQueue();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
    }

    private int pop() {
        return (int) queue1.poll();
    }

    private void push(int data) {
        queue2.add(data);

        while (!queue1.isEmpty()){
            queue2.add(queue1.poll());
        }

        Queue temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
}
