package com.basic.javacustoms;

/**
 * Created by gurinder on 15/7/16.
 */
public class CustomLinkedHashSetApp {
    public static void main(String[] args) {
        CustomLinkedHashSet<String> set = new CustomLinkedHashSet<>();
        set.add("master");
        set.add("master1");
        set.add("master2");
        set.add("master");
        set.printAll();
    }
}


class CustomLinkedHashSet<E> {

    private static final int CAPACITY = 10;

    private Node[] root;
    private Node lastInserted;
    private Node start;

    public CustomLinkedHashSet() {
        root = new Node[CAPACITY];
    }


    class Node<E> {
        Node previous;
        E data;
        Node next;
        Node after;

        public Node(Node previous, E data, Node next) {
            this.previous = previous;
            this.data = data;
            this.next = next;
        }
    }

    public void add(E data) {
        Node<E> newNode = new Node<>(null, data, null);
        int hash = hash(data);
        if (root[hash] == null) {
            root[hash] = newNode;
            if (lastInserted != null)
                lastInserted.after = newNode;
            lastInserted = newNode;
            if (start == null) {
                start = newNode;
            }

            return;
        } else {
            Node<E> current = root[hash];
            ;
            while (current != null) {
                if (current.data.equals(newNode.data)) {
                    if (root[hash].previous == null) {
                        root[hash] = newNode;
                        lastInserted.after = newNode;
                    } else {
                        Node<E> previous = root[hash].previous;
                        root[hash] = newNode;
                        previous.next = newNode;
                        newNode.previous = previous;
                        lastInserted.after = newNode;
                    }
                    lastInserted = newNode;
                    return;
                } else {
                    if (current.next == null) {
                        current.next = newNode;
                        newNode.previous = current;
                        lastInserted.after = newNode;
                        lastInserted = newNode;
                        return;
                    }
                }
                current = current.next;
            }
        }
    }

    public void printAll() {
        while (start != null) {
            System.out.println(start.data);
            start = start.after;
        }

    }

    private int hash(E e) {
        return Math.abs(e.hashCode()) % CAPACITY;
    }


}