package com.basic.javacustoms;

/**
 * Created by gurinder on 22/6/16.
 */
public class CustomLinkedListApp {
    public static void main(String[] args) {
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.display();
        linkedList.remove(6);
        linkedList.display();
    }

}

class CustomLinkedList<V> {
    public CustomLinkedList() {
    }

    Node<V> head;


    static class Node<V> {
        Node<V> next;
        V data;

        public Node(V data, Node<V> next) {
            this.next = next;
            this.data = data;
        }
    }

    public void add(V data) {
        Node<V> newNode = new Node<>(data, null);
        if (head == null)
            head = newNode;
        else {
            Node<V> previous = null;
            Node<V> top = head;
            while (head != null) {
                previous = head;
                head = head.next;
            }
            previous.next = newNode;
            head = top;
        }

    }

    public void remove(V data) {
        if (head == null)
            System.out.println("No element present");
        else {
            Node<V> temp = head;
            Node<V> previous = null;
            while (temp != null) {
                if (temp.data == data)
                    break;
                previous = temp;
                temp = temp.next;
            }
            previous.next = temp.next;
        }
    }

    public void display() {
        if (head == null)
            System.out.println("[]");
        else {
            Node<V> temp = head;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }

        }

    }
}