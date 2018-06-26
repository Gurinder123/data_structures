package com.prac;

public class LRUCache {

    private int capacity = 3;
    private int front = -1;
    private int rear = -1;
    private DLL node;

    public static void main(String[] args) {
        LRUCache cache = new LRUCache();
        cache.add(1);
        cache.add(2);
        cache.add(3);
        cache.add(4);

        cache.printCache();

        cache.add(5);
        cache.add(6);
        cache.printCache();
    }

    private void printCache() {
        DLL temp = node;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private void add(int data) {
        if (rear == capacity - 1 && removeEldestElement()) {
            DLL newNode = new DLL(data);
            node.previous = newNode;
            newNode.next = node;
            node = newNode;
        } else {
            if (node == null) {
                node = new DLL(data);
                front = rear = 0;
            } else {
                DLL temp = node;

                while (temp.next != null) {
                    temp = temp.next;
                }

                DLL newNode = new DLL(data);
                temp.next = newNode;
                newNode.previous = temp;
                rear = rear + 1;
            }
        }
    }

    private boolean removeEldestElement() {
        int i = 1;
        DLL temp = node;
        while (i < capacity - 1) {
            temp = temp.next;
            i++;
        }

        temp.next = null;
        return true;
    }


    static class DLL {
        int data;
        DLL previous;
        DLL next;

        public DLL(int data) {
            this.data = data;
        }
    }
}
