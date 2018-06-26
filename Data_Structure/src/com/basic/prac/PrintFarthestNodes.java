package com.prac;

import java.util.LinkedList;
import java.util.Queue;

class master{
    public master() {
        System.out.println("Papa");
    }
}
public class PrintFarthestNodes extends master{

    {
        System.out.println("Block1");
    }
    {
        System.out.println("Block2");
    }

    static {
        System.out.println("Static Block2");
    }
    static {
        System.out.println("Static Block1");
    }


    public PrintFarthestNodes() {

        System.out.println("Constructor");
    }

    public static void main(String[] args) {
//        Node root = new Node(2);
//        root.up = new Node(1);
//        root.right = new Node(4);
//        root.right.left = root;
//        root.left = new Node(5);
//        root.down = new Node(3);
//        root.down.up = root;
//        root.left.down = new Node(8);
//        root.left.down = root.down;
//        root.right.right = new Node(9);
//        root.right.right.left = root.right;
//        root.down.right = new Node(6);
//        root.down.right.left = root.down;
//        root.down.right.down = new Node(7);
//        root.down.right.down.up = root.down.right;
//
//        Graph graph = new Graph(root);
//        System.out.println("Longest path view of the graph:");
//        graph.longestPathView();

        PrintFarthestNodes node1 = new PrintFarthestNodes();
        PrintFarthestNodes node2 = new PrintFarthestNodes();
    }

    static class Graph {
        Node root;

        public Graph(Node node) {
            root = node;
        }

        public void longestPathView() {
            if (root == null)
                return;

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            LinkedList<Integer> list= new LinkedList<>();

            while (!queue.isEmpty()) {
                Node temp = queue.remove();
                list.add(temp.data);

                if (temp.left != null) {
                    queue.add(temp.left);
                }

                if (temp.right != null) {
                    queue.add(temp.right);
                }

                if (temp.up != null) {
                    queue.add(temp.up);
                }

                if (temp.down != null) {
                    queue.add(temp.down);
                }
            }

            list.forEach(System.out::println);
        }
    }

    static class Node {
        int data;
        Node left, right, up, down;
        int hd;

        public Node(int key) {
            data = key;
            hd = 0;
            left = right = up = down = null;
        }
    }
}
