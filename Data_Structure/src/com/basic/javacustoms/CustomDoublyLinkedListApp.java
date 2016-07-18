package com.basic.javacustoms;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * Created by Gurinder on 7/14/2016.
 */
public class CustomDoublyLinkedListApp {
    public static void main(String[] args) {
        CustomDoublyLinkedList<Integer> linkedList = new CustomDoublyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.remove(4);
        linkedList.add(100, 1);
        linkedList.add(101, 2);
        linkedList.add(3, 6);
        for (int val : linkedList)
            System.out.print(val + " ");
    }
}

class CustomDoublyLinkedList<E> implements Iterable<E> {
    Node root;
    Node element, previous;

    @Override
    public Iterator<E> iterator() {
        element = root;
        Iterator it = new ListIterator() {
            @Override
            public boolean hasNext() {
                return element != null;
            }

            @Override
            public E next() {
                previous = element;
                element = element.next;
                return (E) previous.data;
            }

            @Override
            public boolean hasPrevious() {
                return previous != null;
            }

            @Override
            public E previous() {
                element = previous;
                previous = previous.previous;
                return (E) element.data;
            }

            @Override
            public int nextIndex() {
                return 0;
            }

            @Override
            public int previousIndex() {
                return 0;
            }

            @Override
            public void remove() {

            }

            @Override
            public void set(Object o) {

            }

            @Override
            public void add(Object o) {

            }
        };
        return it;
    }


    class Node<E> {
        Node previous;
        E data;
        Node next;

        public Node(Node previous, E data, Node next) {
            this.previous = previous;
            this.data = data;
            this.next = next;
        }
    }


    public void add(E data) {
        Node<E> newEntry = new Node<>(null, data, null);
        if (root == null) {
            root = newEntry;
            return;
        } else {
            Node current = root;
            Node previous = null;
            while (current != null) {
                previous = current;
                current = current.next;
            }
            previous.next = newEntry;
            newEntry.previous = previous;
        }
    }

    public void add(E data, int index) {
        Node<E> newEntry = new Node<>(null, data, null);
        if (root == null) {
            System.out.println("[]");
            return;
        }
        Node current = root;
        Node previous = null;
        if (index == 1) {
            root = newEntry;
            newEntry.next = current;
            return;
        } else {
            int count = 1;
            while (current != null && count < index) {
                previous = current;
                current = current.next;
                count++;
            }
            previous.next = newEntry;
            newEntry.previous = previous;
            newEntry.next = current;

        }
    }

    public void printAll() {
        Node current = root;
        if (current == null) {
            System.out.println("[]");
            return;
        } else {
            System.out.print("[ ");
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println("]");
        }
    }

    public void remove(E data) {
        if (root == null) {
            System.out.println("[]");
            return;
        }
        Node previous = null;
        Node current = root;
        if (current.data == data) {
            root = current.next;
            current.next.previous = null;
            return;
        }
        while (current != null) {
            if (current.data == data)
                break;

            previous = current;
            current = current.next;
        }
        previous.next = current.next;
        if (current.next != null)
            current.next.previous = previous;
    }

}


