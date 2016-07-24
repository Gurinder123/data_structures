package com.basic;

/**
 * Created by gurinder on 24/7/16.
 */
public class LinkedListIntersection {
    public static void main(String[] args) {
        Node<Integer> node1 = new Node(1, null);
        Node<Integer> node2 = new Node(1, null);
        int intersection = getIntersection(node1, node2);
        System.out.println(intersection);
    }

    private static int getIntersection(Node<Integer> node1, Node<Integer> node2) {
        int c1 = getCount(node1);
        int c2 = getCount(node2);
        int d = 0;
        if (c1 > c2) {
            d = c1 - c2;
            d = getIntersectionNode(d, node1, node2);
        } else {
            d = c2 - c1;
            d = getIntersectionNode(d, node2, node1);
        }
        return d;

    }

    private static int getIntersectionNode(int d, Node<Integer> node1, Node<Integer> node2) {
        for (int i = 0; i < d; i++) {
            if (node1 == null)
                return -1;
            node1 = node1.next;
        }

        while (node1 != null && node2 != null) {
            if (node1 == node2)
                return node1.data;
            node1 = node1.next;
            node2 = node2.next;
        }
        return -1;
    }

    private static int getCount(Node<Integer> node) {
        int count = 0;
        while (node != null) {
            ++count;
            node = node.next;
        }
        return count;
    }

}

