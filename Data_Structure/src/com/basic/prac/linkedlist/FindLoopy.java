package com.prac.linkedlist;

public class FindLoopy {

    public static void main(String[] args) {

        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next = new Node(7);
        node.next.next.next.next.next.next.next = node.next.next;

        findLoopy(node);
    }

    private static void findLoopy(Node head) {

        Node fast = head, slow = head;

        while (fast != null) {

            fast = fast.next;

            System.out.println("Before Comparison positions are fast= " + fast.val + " slow= " + slow.val);
            if (slow == fast) {
                System.out.println("Meet at " + slow.val);
                break;
            }

            if (fast == null)
                break;

            fast = fast.next;

            System.out.println("Before Comparison positions are fast= " + fast.val + " slow= " + slow.val);
            if (slow == fast) {
                System.out.println("Meet at " + slow.val);
                break;
            }

            slow = slow.next;
        }

        slow = head;

        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        System.out.println("Positions are " + slow.val);
    }

    static void printMe(Node node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    private static class Node {

        Node next;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }
}
