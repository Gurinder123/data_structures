package com.prac;

import java.util.*;
import java.util.LinkedList;

public class FortyFiveDegreeTreeView {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.left.right = new Node(8);
        root.right.right = new Node(7);
        Tree tree = new Tree(root);
        System.out.println("Forty Five Degree view:");
        tree.fortyFiveView();
        int i = 100 / 1000;
        System.out.println("***********"+i);
    }

    static class Tree {
        Node root;

        public Tree(Node node) {
            root = node;
        }

        public void fortyFiveView() {
            if (root == null)
                return;

            int hd = 0;

            Map<Integer, Integer> map = new TreeMap<>();

            Queue<Node> queue = new LinkedList<>();

            root.hd = hd;
            queue.add(root);

            while (!queue.isEmpty()) {
                Node temp = queue.poll();

                hd = temp.hd;

                map.put(hd, temp.data);

                if (temp.left != null) {
                    temp.left.hd = hd - 1;
                    queue.add(temp.left);
                }

                if (temp.right != null) {
                    temp.right.hd = hd + 1;
                    queue.add(temp.right);
                }
            }

            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();

            while (iterator.hasNext()) {

                Map.Entry<Integer, Integer> me = iterator.next();
                System.out.print(me.getValue() + " ");
            }
        }
    }

    static class Node {
        int data;
        Node left, right;
        int hd;

        public Node(int key) {
            data = key;
            hd = 0;
            left = right = null;
        }
    }
}
