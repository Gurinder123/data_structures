package com.prac.tree;
import java.util.Stack;

public class RemoveElementsOutsideRangeFromBST {

    public static void main(String[] args) {

        RemoveElementsOutsideRangeFromBST bst = new RemoveElementsOutsideRangeFromBST();

        BST root = new BST();

        root.node = bst.insert(root.node, 10);
        root.node = bst.insert(root.node, 5);
        root.node = bst.insert(root.node, 13);

        bst.inorder(root.node);

//        bst.trimOutsideBST(root.node, 10, 13);
//
//        System.out.println("\n");
//        bst.inorder(root.node);

        bst.trimInsideBST(root.node, 1, 10);

        System.out.println("\n");
        bst.inorder(root.node);

    }

    private Node trimInsideBST(Node node, int L, int R) {

        if (node == null)
            return node;


        if (node.data < R)
            return trimInsideBST(node.left, L, R);
        if (node.data > L)
            return trimInsideBST(node.right, L, R);

        node.left = trimInsideBST(node.left, L, R);
        node.right = trimInsideBST(node.right, L, R);

        return node;
    }

    public Node trimOutsideBST(Node root, int L, int R) {
        if (root == null) return root;

        if (root.data > R)
            return trimOutsideBST(root.left, L, R);
        if (root.data < L)
            return trimOutsideBST(root.right, L, R);

        root.left = trimOutsideBST(root.left, L, R);
        root.right = trimOutsideBST(root.right, L, R);
        return root;
    }

    private Node insert(Node root, int data) {

        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data > root.data)
            root.right = insert(root.right, data);
        else
            root.left = insert(root.left, data);

        return root;
    }

    static class BST {
        private Node node;
    }

    private void inorder(Node node) {

        Stack<Node> stack = new Stack<>();

        Node temp = node;

        while (true) {

            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }

            if (stack.isEmpty())
                return;

            temp = stack.pop();
            System.out.print(temp.data + " ");
            temp = temp.right;
        }
    }

}
