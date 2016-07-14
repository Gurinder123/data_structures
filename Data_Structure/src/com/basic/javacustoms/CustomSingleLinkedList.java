package com.basic.javacustoms;

import java.util.Iterator;

/**
 * Created by gurinder on 13/7/16.
 */
public class CustomSingleLinkedList<E> implements Iterable<E> {
    Node root;

    @Override
    public Iterator<E> iterator() {
        final Node[] iterate = {root};
        final Node[] next = {null};
        final Iterator<E> iterator = new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return iterate[0].next != null;
            }

            @Override
            public E next() {
                next[0] = iterate[0];
                return (E) next[0].data;
            }
        };
        return iterator;
    }

    class Node<E> {
        E data;
        Node next;

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        CustomSingleLinkedList<Integer> linkedList = new CustomSingleLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        for (Integer linkedList1 : linkedList) {
            System.out.println(linkedList1);
        }
        System.out.println("After Removing");
        linkedList.remove(1);
        linkedList.printAll();
    }


    private void remove(E val) {
        if (root == null) {
            System.out.print("Empty List");
            return;
        }

        if (root.data == val) {
            root = root.next;
        } else {
            Node current, previous = null;
            current = root;
            while (current != null) {
                if (current.data == val) {
                    break;
                }
                previous = current;
                current = current.next;
            }
            previous.next = current.next;
        }

    }

    private void printAll() {
        if (root == null) {
            System.out.print("Empty List");
            return;
        } else {
            Node current = root;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
        }
    }

    private void add(E data) {
        Node newNode = new Node(data, null);
        if (root == null) {
            root = newNode;
            return;
        } else {
            Node current, previous = null;
            current = root;
            while (current != null) {
                previous = current;
                current = current.next;
            }
            previous.next = newNode;
        }


    }
}
