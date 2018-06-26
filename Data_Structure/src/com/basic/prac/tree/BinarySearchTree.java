package com.prac.tree;

import java.util.*;

import static java.util.Objects.nonNull;

class BinarySearchTree {
    /* Class containing left and right child of current node and key value*/
    class Node {
        int key;
        Node left, right;
        int hd;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // Root of BST
    Node root;

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    // This method mainly calls deleteRec()
    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    /* A recursive function to insert a new key in BST */
    Node deleteRec(Node root, int key) {
        /* Base Case: If the tree is empty */
        if (root == null) return root;

        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);

            // if key is same as root's key, then This is the node
            // to be deleted
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    // This method mainly calls insertRec()
    void insert(int key) {
        root = insertRec(root, key);
    }

    /* A recursive function to insert a new key in BST */
    Node insertRec(Node root, int key) {

        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }

    // This method mainly calls InorderRec()
    void inorder() {
        inorderRec(root);
    }

    // A utility function to do inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Driver Program to test above functions
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80
                / \
              51   62   */

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.insert(51);
        tree.insert(62);

        System.out.println("Left traversal of the given tree");
        tree.leftView(tree.root, 1);

        System.out.println("\nRight traversal of the given tree");
        tree.rightView(tree.root, 1);

        System.out.println("\nBottom traversal of the given tree");
        tree.bottomView(tree.root);

        System.out.println("\nTop traversal of the given tree");
        tree.topView(tree.root);

        System.out.println("\nLca of 60 and 80 is: " + tree.lca(tree.root, 60, 80).key);

        System.out.println("\nPrint Ancestors of 60 an 80 is:");
        tree.printAncestor(tree.root, 51, 62);

        System.out.println("\nInorder traversal of the given tree");
        tree.inorder();

        System.out.println("\nDelete 20");
        tree.deleteKey(80);

        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 30");
        tree.deleteKey(30);

        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 70");
        tree.deleteKey(50);

        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

    }

    private boolean printAncestor(Node node, int val1, int val2) {

        if (node == null)
            return false;

        if (node.key == val1 || node.key == val2)
            return true;

        if (printAncestor(node.left, val1, val2) || printAncestor(node.right, val1, val2)){
            System.out.print(node.key + " ");
            return true;
        }

        return false;
    }

    private Node lca(Node node, int val1, int val2) {

        if (node == null)
            return node;

        if (node.key == val1 || node.key == val2)
            return node;

        Node left_lca = lca(node.left, val1, val2);
        Node right_lca = lca(node.right, val1, val2);

        if (left_lca != null && right_lca != null)
            return node;

        return left_lca == null ? right_lca : left_lca;
    }

    private void topView(Node node) {

        Set<Integer> set = new TreeSet<>();
        Queue<Node> queue = new LinkedList<>();

        int hd = node.hd;

        queue.add(node);

        while (!queue.isEmpty()) {

            Node temp = queue.poll();

            hd = temp.hd;

            if (!set.contains(hd)) {
                System.out.print(temp.key + " ");
                set.add(temp.hd);
            }

            if (nonNull(temp.left)) {
                temp.left.hd = hd - 1;
                queue.add(temp.left);
            }

            if (nonNull(temp.right)) {
                temp.right.hd = hd + 1;
                queue.add(temp.right);
            }

        }

    }

    int maxLevelLeft;

    private void leftView(Node node, int level) {

        if (node == null)
            return;

        if (maxLevelLeft < level) {
            System.out.print(node.key + " ");
            maxLevelLeft = level;
        }

        leftView(node.left, level + 1);
        leftView(node.right, level + 1);

    }

    int maxRightLeft;

    private void rightView(Node node, int level) {

        if (node == null)
            return;

        if (maxRightLeft < level) {
            System.out.print(node.key + " ");
            maxLevelLeft = level;
        }

        leftView(node.right, level + 1);
        leftView(node.left, level + 1);

    }

    private void bottomView(Node node) {

        Map<Integer, Node> map = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();

        int hd = node.hd;

        queue.add(node);

        while (!queue.isEmpty()) {

            Node temp = queue.poll();

            hd = temp.hd;

            map.put(temp.hd, temp);

            if (nonNull(temp.left)) {
                temp.left.hd = hd - 1;
                queue.add(temp.left);
            }

            if (nonNull(temp.right)) {
                temp.right.hd = hd + 1;
                queue.add(temp.right);
            }

        }

        map.entrySet().stream().forEach((k) -> System.out.print(k.getValue().key + " "));

    }
}