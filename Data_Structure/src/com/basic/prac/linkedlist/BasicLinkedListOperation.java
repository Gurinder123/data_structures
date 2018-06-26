package com.prac.linkedlist;

import java.util.Objects;

public class BasicLinkedListOperation {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next = new Node(7);
        node.next.next.next.next.next.next.next = new Node(8);

        // Print in recursive order sequentially
        printInorder(node);

        int data = findknthNode(node, 3);


        System.out.println();
        System.out.println(data);
//
//        System.out.println();
//        // Print in recursive order ReverseOrder
//        printInReverseOrder(node);
//
//        System.out.println();
//        // Print using loop in order sequentially
//        traversingInNormalOrder(node);
//
//        System.out.println();
//        // Insertion at beginning
//        node = insertionAtStarting(node, 0);
//
//        System.out.println();
//        // Insertion at ending
//        insertionAtEnding(node, 5);
//
//        System.out.println();
//        // Insertion at ending
//        insertionAtMiddle(node, 2, 10);
//
//        System.out.println();
//        // Insertion at ending
//        deletingfromMiddle(node, 2);
    }

    private static int findknthNode(Node node, int i) {
        Node temp1 = node, temp2 = node;

        int count = 1;

        while (Objects.nonNull(temp1)) {

            if (count > i)
                temp2 = temp2.next;

            temp1 = temp1.next;
            count++;
        }

        return temp2.data;
    }

    private static void deletingfromMiddle(Node node, int pos) {
        if (Objects.isNull(node)) {
            System.out.println("Empty List");
        } else {
            int count = 1;
            Node traverse = node;
            Node temp = null;
            while (count < pos) {
                temp = traverse;
                traverse = traverse.next;
                count++;
            }
            temp.next = traverse.next;
            printInorder(node);
        }
    }

    private static void insertionAtMiddle(Node node, int pos, int data) {
        if (Objects.isNull(node)) {
            System.out.println("Empty List");
        } else {
            Node newNode = new Node(data);

            int count = 1;
            Node traverse = node;
            while (count < pos) {
                traverse = traverse.next;
                count++;
            }
            newNode.next = traverse.next;
            traverse.next = newNode;
            printInorder(node);
        }
    }

    private static void insertionAtEnding(Node node, int data) {
        Node newNode = new Node(data);
        if (Objects.isNull(node)) {
            node = newNode;
            printInorder(node);
        } else {
            Node temp = null;
            Node traverse = node;
            while (Objects.nonNull(traverse)) {
                if (traverse.next == null) {
                    temp = traverse;
                    break;
                } else {
                    traverse = traverse.next;
                }
            }
            temp.next = newNode;
            printInorder(node);
        }

    }

    private static Node insertionAtStarting(Node node, int data) {
        Node newNode = new Node(data);
        if (Objects.isNull(node)) {
            node = newNode;
            printInorder(node);
        } else {
            newNode.next = node;
            printInorder(newNode);
        }

        return newNode;
    }

    private static void traversingInNormalOrder(Node node) {
        if (Objects.isNull(node)) {
            System.out.print("Empty List");
            return;
        }

        while (Objects.nonNull(node)) {
            System.out.print(" " + node.data);
            node = node.next;
        }
    }

    private static void printInorder(Node node) {
        if (Objects.isNull(node))
            return;

        System.out.print(" " + node.data);
        printInorder(node.next);
    }

    private static void printInReverseOrder(Node node) {
        if (Objects.isNull(node))
            return;

        printInReverseOrder(node.next);
        System.out.print(" " + node.data);
    }

    private static class Node {
        private int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }
}
