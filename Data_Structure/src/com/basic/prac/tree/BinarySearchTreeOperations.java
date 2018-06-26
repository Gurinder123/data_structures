package com.prac.tree;

public class BinarySearchTreeOperations {
    public static void main(String[] args) {

        Node root = insertData(null, 1);
        root = insertData(root, 2);
        root = insertData(root, 3);
        root = insertData(root, -1);

        inOrderTraversal(root);
    }

    private static void inOrderTraversal(Node root) {
        if (root == null)
            return;
        else {
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }

    }

    private static Node insertData(Node node, int data) {
        if (node == null)
            return new Node(data);

        if (node.data > data)
            node.left = insertData(node.left, data);
        else
            node.right = insertData(node.right, data);

        return node;
    }

    static class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

}
