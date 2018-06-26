package com.prac.tree;

// Java program to construct tree from inorder traversal

import java.util.LinkedList;
import java.util.Queue;

import static java.util.Objects.nonNull;

/* A binary tree node has data, pointer to left child
   and a pointer to right child */
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class ConstructBinaryTree {
    Node root;

    /* Recursive function to construct binary of size len from
       Inorder traversal inorder[]. Initial values of start and end
       should be 0 and len -1.  */
    Node buildTree(int inorder[], int start, int end, Node node) {
        if (start > end)
            return null;

        /* Find index of the maximum element from Binary Tree */
        int i = max(inorder, start, end);

        /* Pick the maximum value and make it root */
        node = new Node(inorder[i]);

        /* If this is the only element in inorder[start..end],
         then return it */
        if (start == end)
            return node;

        /* Using index in Inorder traversal, construct left and
         right subtress */
        node.left = buildTree(inorder, start, i - 1, node.left);
        node.right = buildTree(inorder, i + 1, end, node.right);

        return node;
    }

    /* UTILITY FUNCTIONS */

    /* Function to find index of the maximum value in arr[start...end] */
    int max(int arr[], int strt, int end) {
        int i, max = arr[strt], maxind = strt;
        for (i = strt + 1; i <= end; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxind = i;
            }
        }
        return maxind;
    }

    /* This funtcion is here just to test buildTree() */
    void printInorder(Node node) {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.data + " ");

        /* now recur on right child */
        printInorder(node.right);
    }

    public static void main(String args[]) {
        ConstructBinaryTree tree = new ConstructBinaryTree();

        /* Assume that inorder traversal of following tree is given
             40
            /   \
          10     30
         /         \
        5          28 */

        int inorder[] = new int[]{5, 10, 40, 30, 28};
        int len = inorder.length;
        Node mynode = tree.buildTree(inorder, 0, len - 1, tree.root);

        /* Let us test the built tree by printing Inorder traversal */
        System.out.println("Inorder traversal of the constructed tree is ");
        tree.printInorder(mynode);

        System.out.println("\nDiameter of a tree is ");
        System.out.println(tree.diameter(mynode));

//        tree.delete(mynode, 5);
//        System.out.println("After deleting 10 ");
//        tree.printInorder(mynode);

        ConstructBinaryTree anotherTree = new ConstructBinaryTree();

        int preOrder[] = {40, 10, 5, 30, 28};

        Node anotherNode = tree.buildTree(inorder, preOrder, 0, len - 1, anotherTree.root);

        System.out.println("After Constructing from in order and  pre order");
        tree.printInorder(anotherNode);

        anotherTree = new ConstructBinaryTree();

        int postOrder[] = {5, 10, 28, 30, 40};

        System.out.println("\nAfter Constructing from in order and  post order");
        anotherNode = tree.buildTreeWithPostAndInorder(inorder, postOrder, 0, len - 1, anotherTree.root);
        tree.printInorder(anotherNode);
    }

    int postOrderIndex = 4;

    private Node buildTreeWithPostAndInorder(int[] inorder, int[] postOrder, int start, int end, Node node) {

        if (start > end)
            return null;

        if (node == null)
            node = new Node(postOrder[postOrderIndex--]);

        if (start == end)
            return node;

        int index = findIndex(inorder, start, end, node.data);

        node.right = buildTreeWithPostAndInorder(inorder, postOrder, index + 1, end, node.right);
        node.left = buildTreeWithPostAndInorder(inorder, postOrder, start, index - 1, node.left);

        return node;
    }

    int preOrderIndex = 0;

    private Node buildTree(int[] inorder, int[] givenOrder, int start, int end, Node node) {

        if (start > end)
            return null;

        if (node == null)
            node = new Node(givenOrder[preOrderIndex++]);


        if (start == end)
            return node;

        int index = findIndex(inorder, start, end, node.data);

        node.left = buildTree(inorder, givenOrder, start, index - 1, node.left);
        node.right = buildTree(inorder, givenOrder, index + 1, end, node.right);

        return node;
    }

    private int findIndex(int[] inorder, int start, int end, int val) {

        int index = 0;

        for (int i = start; i < end; i++) {
            if (inorder[i] == val)
                index = i;

        }
        return index;
    }

    private int diameter;

    private int diameter(Node node, int diameter) {

        if (node == null)
            return 0;

        int left = diameter(node.left, diameter);
        int right = diameter(node.right, diameter);

        if (left + right > diameter)
            this.diameter = left + right;

        return Math.max(left, right) + 1;
    }

    int diameter(Node root) {
        if (root == null)
            return 0;

        int lheight = height(root.left);
        int rheight = height(root.right);

        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);

        return Math.max(lheight + rheight + 1,
                Math.max(ldiameter, rdiameter));

    }

    static int height(Node node) {
        if (node == null)
            return 0;

        return (1 + Math.max(height(node.left), height(node.right)));
    }

    private void delete(Node node, int data) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        Node nodeToBeDeleted = null;
        Node temp = null;

        while (!queue.isEmpty()) {
            temp = queue.poll();

            if (temp.data == data)
                nodeToBeDeleted = temp;

            if (nonNull(temp.left))
                queue.add(temp.left);

            if (nonNull(temp.right))
                queue.add(temp.right);
        }

        int key = temp.data;
        deleteNode(node, key);
        nodeToBeDeleted.data = key;
    }

    private Node deleteNode(Node root, int nodeToBeDeleted) {
        if (root == null)
            return root;

        if (root.data == nodeToBeDeleted)
            return null;

        root.left = deleteNode(root.left, nodeToBeDeleted);
        root.right = deleteNode(root.right, nodeToBeDeleted);

        return root;
    }
}

// This code has been contributed by Mayank Jaiswal
