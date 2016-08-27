package com.basic;

import java.util.Scanner;

/**
 * Created by gurinder on 31/7/16.
 */
public class SumOfTwoLinkedList {
    public static void main(String[] args) {
        Node node1 = createLinkedList("node1");
        Node node2 = createLinkedList("node2");
        int count1 = getCount(node1);
        int count2 = getCount(node2);
        int d = 0;
        if (count1 > count2) {
            d = count1 - count2;
            Node current1 = reverseRequiredPart(d, node1, true);
            sumAll(current1, node2);
        } else {
            d = count2 - count1;
            Node current1 = reverseRequiredPart(d, node2, true);
            sumAll(current1, node1);
        }
    }

    private static Node reverseRequiredPart(int d, Node node, boolean flag) {
        if (flag) {
            for (int i = 0; i < d; i++)
                node = node.next;
        }
        return node;
    }

    private static void sumAll(Node node1, Node node2) {
        String s1 = "";
        String s2 = "";

        while (node1 != null && node2 != null) {
            s1 += node1.data;
            s2 += node2.data;
            node1 = node1.next;
            node2 = node2.next;
        }
        int count = s1.length() - 1;
        int carry = 0;
        int total = 0;
        while (count >= 0) {
            char a1 = s1.charAt(count);
            char a2 = s2.charAt(count--);
            total = ((int) a1 - 48) + ((int) a2 - 48);
            System.out.println(a2 + " " + (int) a2);
        }
    }

    private static int getCount(Node node) {
        int count = 0;
        while (node != null) {
            node = node.next;
            count++;
        }
        return count;
    }

    private static Node createLinkedList(String node) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        Node root = null, current = null;
        do {
            System.out.println("Enter the Data for " + node);
            int value = scanner.nextInt();
            if (root == null) {
                root = new Node(value, null);
                current = root;
            } else {
                Node newNode = new Node(value, null);
                current.next = newNode;
                current = newNode;
            }
            System.out.println("Continue? y or n :");
            String desicion = scanner.next();
            if (desicion.equals("y"))
                flag = true;
            else
                flag = false;
        } while (flag);
        return root;
    }
}
