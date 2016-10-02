package com.basic.javacustoms;

import java.util.Comparator;

/**
 * Created by Gurinder on 10/2/2016.
 */

/*Needs improvement*/
public class CustomBinaryTree {
    public static void main(String[] args) {
        MyBinaryTree<Integer> integerMyTree = new MyBinaryTree<>();
        integerMyTree.add(1);
        integerMyTree.add(2);
        integerMyTree.add(0);
        integerMyTree.add(6);
        integerMyTree.add(4);
        integerMyTree.printAll();
    }


}

class MyBinaryTree<T> {
    Node node;

    public void add(T t) {
        if (node == null) {
            node = new Node(t);
            return;
        }
        Node newNode = new Node(t);
        int cmp;
        Node parent = node;
        Node temp = null;
        boolean flag = true;
        do {
            temp = parent;
            cmp = node.compare(t, parent.data);
            if (cmp < 0) {
                parent = parent.left;
                flag = true;
            } else if (cmp > 0) {
                parent = parent.right;
                flag = false;
            }
        } while (parent != null);
        if (flag) {
            temp.left = newNode;
        } else {
            temp.right = newNode;
        }

    }

    public void printAll() {
        Node parent = node;
        if (parent == null) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        Node tempLeft = parent.left;
        Node tempRight = parent.right;
        while (tempLeft != null) {
            if (tempLeft != null)
                System.out.print(" " + tempLeft.data);
            if (tempLeft != null)
                tempLeft = tempLeft.left;
        }
        System.out.print(" " + node.data);
        while (tempRight != null) {
            if (tempRight != null)
                System.out.print(" " + tempRight.data);
            if (tempRight != null)
                tempRight = tempRight.right;
        }
        System.out.print(" ]");
    }


    private class Node implements Comparator<T> {
        T data;
        Node right;
        Node left;

        public Node(T data) {
            this.data = data;
        }


        @Override
        public int compare(T o1, T o2) {
            if (o1 instanceof String) {
                return ((String) o1).compareTo((String) o2);
            } else {
                return ((Integer) o1).compareTo((Integer) o2);
            }
        }
    }

    public MyBinaryTree() {
    }
}