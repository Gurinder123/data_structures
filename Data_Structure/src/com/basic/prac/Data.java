package com.prac;

public class Data {

    // Why Data Structure ?
    // Store, Manipulation, Traverse, Performance, Systematic way
    // Everything data structre file system is based in tree

    // a) Linear Data Structure
    // Array
    // Linked List
    // Stack
    // Queue


    // b) Non Linear Data Structure
    // Binary Tree
    // Binary Search Tree
    // AVL Tree
    // Graph

    //
    //  Space Complexity
    //  Time Complexity Worst, Best, Average => BIG O, Theta, Omega
    //  O(1) > O(Logn) > O(n) > O(nLogn) > O(n^2).....

    // Search
    // Linear Search O(n)
    // Binary Search O(Logn) always work on sorted array

    // Stable Sort vs Un-Stable Sort

    // [1, 33, 2, 1, 3, 5] => [1, 1, 2, 3, 5, 33] Stable
    // [1, 33, 2, 1, 3, 5] => [1, 1, 2, 3, 5, 33] Un - Stable

    // [ Employee("Gurinder", "Singh", "27"), Employee("Sahil", "Kohli", "27"), Employee("Gurinder", "Panesar", "22" )]
    // [ Employee("Gurinder", "Panesar", "22"),  Employee("Gurinder", "Singh", "27" ), Employee("Sahil", "Kohli", "27")]

    // Merge Sort Stable Sort (nLogn)
    // Bubble Sort Stable Sort

    // Quick Sort Un-Stable Sort (nLogn)
    // Selection Sort Un-Stable Sort

    public static void main(String[] args) {

        // (Contiguous Memory) Integer 4 byte [2000-2004, 2004-2008, 2008-2012]
        // array[0] = (4 * 0) + 2000 (size of element X index + base address)
        // array[1] = (4 * 1) + 2000
        // array[2] = (4 * 2) + 2000

        //
        //
        //

        int[] array = {3, 4, 2, 3, 4, 4, 6};
        // pivot = 3

        // O(1)
        System.out.println(array[0]);


        // Linear Search

        // O(n)
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 5)
                System.out.println("Mil gya");
        }


        // Binary Search

        int start = 0;
        int end = array.length - 1;
        int mid = 0;
        int find = 4;

        // O(logn)
        while (start <= end) {
            mid = (start + end) / 2;

            if (array[mid] == find) {
                System.out.println("Mil gya 4 at position " + mid);
                break;
            }

            if (array[mid] < find)
                start = mid + 1;
            else
                end = mid - 1;


        }

        int[] arrayToSort = {1, 3, 2, 5, 4, 7, 6};

        // O(n) + O(n) = O(n^2)
        // Bubble Sort
        for (int i = 0; i < arrayToSort.length; i++) {

            for (int j = 0; j < arrayToSort.length; j++) {

                if (arrayToSort[i] < arrayToSort[j]) {
                    int temp = arrayToSort[i];
                    arrayToSort[i] = arrayToSort[j];
                    arrayToSort[j] = temp;

                }
            }
        }

        for (int i = 0; i < arrayToSort.length; i++) {
            System.out.print(arrayToSort[i] + " ");
        }

    }

}


// head and tail
// Capacity 3
// head 1 and tail 3
// 1 <==> 2 <==> 3
// tail.prev = 2 now tail = 2
// head = 4 and tail 2
// 4 <==> 1 <==> 2    [X 3 X]

class LinkedList {

    static class Node {

        int data;
        Node mid;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static void main(String[] args) {

        Node node = new Node(1);
        node.mid = new Node(2);
        node.mid.next = new Node(4);
        node.next = new Node(5);
        node.next.mid = new Node(7);
        node.next.mid.next = new Node(9);

        Node temp = node;

        while (temp != null) {
            System.out.print(temp.data + " ");
            printMiddles(temp.mid);
            temp = temp.next;
        }
    }

    private static void printMiddles(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }


    Node head;

    void add(int data) {

        if (head == null) {
            head = new Node(data);
        } else {

            Node temp = head;
            while (temp.next != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }

            temp.next = new Node(data);
        }
    }

    void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    int get(int index) {

        Node temp = head;
        int count = 0;
        int value = 0;

        while (temp != null && count < index) {
            value = temp.data;
            temp = temp.next;
            count++;
        }

        return value;
    }
}

