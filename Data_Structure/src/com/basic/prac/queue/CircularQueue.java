package com.prac.queue;


import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class CircularQueue {

    private int front;
    private int rear;
    private int capacity;
    private int queue[];

    public CircularQueue(int capacity) {

        this.front = -1;
        this.rear = -1;
        this.capacity = capacity;
        this.queue = new int[capacity];

    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.deQueue();

        queue.print();

        Collection collections = Arrays.asList(4, 3, 2, 1);
        PriorityQueue proPriorityQueue = new PriorityQueue(collections);

    }


    private void print() {

        for (int i = front; i <= rear; i++)
            System.out.print(queue[i] + " ");

    }

    private void enQueue(int data) {
        if (isFull())
            throw new ArrayIndexOutOfBoundsException();
        else {
            rear = (rear + 1) % capacity;
            queue[rear] = data;
            if (front == -1)
                front = rear;
        }
    }

    private void deQueue() {
        if (isEmpty())
            throw new ArrayIndexOutOfBoundsException();
        else {
            if (front == rear)
                front = rear - 1;
            else
                front = (front + 1) % capacity;
        }
    }

    private boolean isEmpty() {
        return front == -1;
    }

    private boolean isFull() {
        return (rear + 1) % capacity == front;
    }
}
