package com.prac.tree;

import java.util.*;

public class BinaryTreeTraversalWithRecursion {

    public static void main(String[] args) {


        Node node = null;

//        node = insert(node, 10);
//        node = insert(node, 5);
//        node = insert(node, 1);
//        node = insert(node, 6);
//        node = insert(node, 19);
//        node = insert(node, 17);
//        node = insert(node, 5);
//        node = insert(node, 4);
//        node = insert(node, 6);
//        node = insert(node, 8);

        node = new Node(1);
        node.left = new Node(2);
        node.left.left = new Node(5);
        node.left.right = new Node(6);
//        node.right = new Node(3);
//        node.right.right = new Node(10);


        Tree tree = new Tree(node);


//        System.out.println("Pre-order");
//        preOrderTraversal(tree.root);
//
//        System.out.println("\nPost-order");
//        postOrderTraversal(tree.root);
//
//        System.out.println("\nIn-order");
//        inOrderTraversal(tree.root);
//
//        System.out.println();
//        int maxElement = findMaxElement(tree.root);
//
//        System.out.println("Max Element = " + maxElement);
//
//        mirrorImage(tree.root);
//
//        System.out.println("\nIn-order");
//        inOrderTraversal(tree.root);

        System.out.println();
        deepestRightLeaf(tree.root);

        System.out.println();
        deepestLeftLeaf(tree.root);


        System.out.println();
        System.out.println(findLCA(tree.root, 5, 6).data);

        System.out.println("\nHeight:");
        heightOrDepth(tree.root);

        System.out.println("\nBottom-View:");
        bottomView(tree.root);

        mthod(1);

    }

    private static void bottomView(Node node) {
        node.hd = 0;
        Queue<Node> q = new LinkedList();
        q.add(node);

        int hd = 0;

        Map<Integer, Integer> map = new TreeMap<>();
        while (!q.isEmpty()) {
            Node temp = q.poll();

            hd = temp.hd;
            map.put(hd, temp.data);

            if (Objects.nonNull(temp.left)) {
                temp.left.hd = hd -1;
                q.add(temp.left);
            }
            if (Objects.nonNull(temp.right)) {
                temp.right.hd = hd + 1;
                q.add(temp.right);
            }
        }

        map.entrySet().stream().map(Map.Entry::getValue).forEach(System.out::print);
    }

    private static void heightOrDepth(Node node) {

        Queue<Node> q = new LinkedList();
        q.add(node);
        q.add(null);
        int level = 0;
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp == null) {

                if (!q.isEmpty())
                    q.add(null);

                level++;
            } else {
                if (Objects.nonNull(temp.left))
                    q.add(temp.left);
                if (Objects.nonNull(temp.right))
                    q.add(temp.right);
            }
        }

        System.out.print(level + " ");
    }


    static Node findLCA(Node node, int n1, int n2) {
        if (node == null)
            return null;

        if (node.data == n1 || node.data == n2)
            return node;

        Node left_lca = findLCA(node.left, n1, n2);
        Node right_lca = findLCA(node.right, n1, n2);

        if (left_lca != null && right_lca != null)
            return node;

        return (left_lca != null) ? left_lca : right_lca;
    }

    private static void deepestRightLeaf(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        Node temp = null;
        while (!q.isEmpty()) {
            temp = q.poll();

            if (Objects.nonNull(temp.right))
                q.add(temp.right);
        }

        System.out.println(temp.data);
    }

    private static void deepestLeftLeaf(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        Node temp = null;
        while (!q.isEmpty()) {
            temp = q.poll();

            if (Objects.nonNull(temp.left))
                q.add(temp.left);
        }

        System.out.println(temp.data);
    }

   static  <T>void mthod(T t){
       System.out.println(t);
    }

    static private Node mirrorImage(Node node) {
    mthod(1);

        if (node == null)
            return node;

        Node left = mirrorImage(node.left);
        Node right = mirrorImage(node.right);

        node.left = right;
        node.right = left;

        return node;
    }

    private static int findMaxElement(Node node) {

        int max = 0;
        if (node != null) {
            max = node.data;
            int left = findMaxElement(node.left);
            int right = findMaxElement(node.right);

            if (left > right)
                max = left;
            else
                max = right;

            if (node.data > max)
                max = node.data;
        }

        return max;
    }

    static Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
            return node;
        }
        if (data < node.data)
            node.left = insert(node.left, data);
        else if (node.data < data)
            node.right = insert(node.right, data);

        return node;
    }

    private static void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    private static void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.data + " ");
        }
    }

    private static void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.data + " ");
            inOrderTraversal(node.right);
        }
    }

    static class Tree {
        Node root;

        Tree(Node node) {
            this.root = node;
        }
    }

    static class Node {
        Node left;
        Node right;
        int hd;

        int data;

        Node(int data) {
            this.data = data;
        }
    }

}
