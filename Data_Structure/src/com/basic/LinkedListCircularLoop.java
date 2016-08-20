package com.basic;

/**
 * Created by gurinder on 24/7/16.
 *
 *  find if there ia any loop between in singlylinkedlist
 */
public class LinkedListCircularLoop {
    public static void main(String[] args) {
        Node<Integer> node = new Node(1, null);
        findloop(node);
    }

    private static void findloop(Node<Integer> node) {
        Node slow = node;
        Node faster = node.next;

        while (true) {
            if (faster == null || faster.next == null)
                return;
            else if (faster == slow || faster.next == slow)
                System.out.println("Loop exist");
            else {
                slow = slow.next;
                faster = faster.next;
            }
        }
    }
}


class Node<V> {
    Node<V> next;
    V data;

    public Node(V data, Node<V> next) {
        this.next = next;
        this.data = data;
    }
}
