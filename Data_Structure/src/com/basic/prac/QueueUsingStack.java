package com.prac;

import java.util.Stack;

public class QueueUsingStack {

    static Stack stack1 = new Stack();
    static Stack stack2 = new Stack();

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enque(1);
        q.enque(2);
        q.enque(3);

        System.out.println(q.deEnque());
        System.out.println(q.deEnque());
        System.out.println(q.deEnque());
    }


    static class Queue {

        public void enque(int i) {
         stack1.push(i);
        }

        public int deEnque() {

            if (stack1.size() == 1){
                return (int) stack1.pop();
            }

            Stack copy = (Stack) stack1.clone();

            while (!copy.isEmpty()) {
                stack2.push(copy.pop());
            }

            Integer value = (Integer) stack2.pop();
            stack2.clear();
            return value;
        }


    }
}
