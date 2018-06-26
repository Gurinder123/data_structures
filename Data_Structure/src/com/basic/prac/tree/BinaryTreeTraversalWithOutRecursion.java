package com.prac.tree;

import java.util.*;

import static java.util.Objects.nonNull;

public class BinaryTreeTraversalWithOutRecursion {

    public static void main(String[] args) {
        Node node = new Node(10);

        node.left = new Node(5);

        node.right = new Node(19);
        node.right.left = new Node(17);

        Tree tree = new Tree(node);


        System.out.println("In-order");
        inOrderTraversal(tree.root);

        System.out.println("\nPost-order");
        postOrderTraversalUsingTwoStack(tree.root);

        System.out.println("\nPost-order");
        postOrderTraversalUsingOneStack(tree.root);

        System.out.println("\nPre-order");
        preOrderTraversal(tree.root);

        System.out.println("\nLevel-order");
        levelOrderTraversal(tree.root);

        System.out.println("\nPrint-ancestors");
        printAncestors(tree.root, -1);


//        System.out.println("\nLeast-common-ancestors\n" + findLCA(tree.root, 0, -1).data);

        System.out.println("\nBottom-view");
        bottomView(tree.root);

        System.out.println("\nLeft-view");
        leftViewUtil(tree.root, 1);

        System.out.println("\nRight-view");
        rightViewUtil(tree.root, 1);

        System.out.println("\nSpiral-iterative");
        printSpiral(tree.root);

        Node temp = new Node(2);

        temp.left = new Node(1);
        temp.right = new Node(3);

        Tree t = new Tree(temp);

        System.out.println("\nis Binary " + isBST(t.root));

        System.out.println("\nTop-view");
        topView(tree.root);

    }


    private static void postOrderTraversalUsingOneStack(Node node) {

        Stack<Node> S = new Stack<Node>();

        if (node == null)
            return;

        S.push(node);
        Node prev = null;

        while (!S.isEmpty()) {
            Node current = S.peek();

            if (prev == null || prev.left == current ||
                    prev.right == current) {
                if (current.left != null)
                    S.push(current.left);
                else if (current.right != null)
                    S.push(current.right);
                else {
                    System.out.print(S.pop().data+" ");
                }

            } else if (current.left == prev) {
                if (current.right != null)
                    S.push(current.right);
                else {
                    System.out.print(S.pop().data+" ");
                }

            } else if (current.right == prev) {
                System.out.print(S.pop().data+" ");
            }

            prev = current;
        }
    }

    private static void topView(Node node) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        Set<Integer> set = new HashSet<>();
        int hd = 0;
        while (!queue.isEmpty()) {

            Node temp = queue.poll();
            hd = temp.hd;

            if (!set.contains(temp.hd)) {
                System.out.print(temp.data + " ");
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

    static int right_Max_level = 0;

    private static void rightViewUtil(Node node, int level) {

        if (node == null)
            return;

        if (right_Max_level < level) {
            System.out.print(node.data + " ");
            right_Max_level = level;
        }

        rightViewUtil(node.right, level + 1);
        rightViewUtil(node.left, level + 1);
    }

    static Node prev;

    static boolean isBST(Node node) {
        if (node != null) {
            if (!isBST(node.left))
                return false;

            if (prev != null && node.data <= prev.data)
                return false;

            prev = node;
            return isBST(node.right);
        }
        return true;
    }

    static void printSpiral(Node node) {
        if (node == null)
            return;

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(node);

        while (!s1.empty() || !s2.empty()) {
            while (!s1.empty()) {
                Node temp = s1.peek();
                s1.pop();
                System.out.print(temp.data + " ");

                if (temp.right != null)
                    s2.push(temp.right);

                if (temp.left != null)
                    s2.push(temp.left);

            }

            while (!s2.empty()) {
                Node temp = s2.peek();
                s2.pop();
                System.out.print(temp.data + " ");

                if (temp.left != null)
                    s1.push(temp.left);
                if (temp.right != null)
                    s1.push(temp.right);
            }
        }
    }

    static int max_level = 0;

    static void leftViewUtil(Node node, int level) {
        if (node == null) return;

        if (max_level < level) {
            System.out.print(" " + node.data);
            max_level = level;
        }

        leftViewUtil(node.left, level + 1);
        leftViewUtil(node.right, level + 1);
    }

    private static void bottomView(Node node) {

        Queue<Node> q = new LinkedList<>();
        int hd = 0;
        node.hd = hd;

        q.add(node);

        Map<Integer, Integer> map = new TreeMap<>();
        while (!q.isEmpty()) {
            Node temp = q.poll();

            hd = temp.hd;
            map.put(hd, temp.data);

            if (nonNull(temp.left)) {
                temp.left.hd = hd - 1;
                q.add(temp.left);
            }
            if (nonNull(temp.right)) {
                temp.right.hd = hd + 1;
                q.add(temp.right);
            }
        }

        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next().getValue() + " ");
        }
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

        Node temp = (left_lca != null) ? left_lca : right_lca;

        return temp;
    }

    private static boolean printAncestors(Node node, int data) {
        if (node == null)
            return false;

        if (node.data == data)
            return true;

        if (printAncestors(node.left, data) || printAncestors(node.right, data)) {
            System.out.print(node.data + " ");
            return true;
        }

        return false;
    }

    private static void preOrderTraversal(Node root) {
        Stack<Node> stack = new Stack<>();
        while (true) {

            while (root != null) {
                System.out.print(root.data + " ");
                stack.push(root);
                root = root.left;
            }
            if (stack.empty())
                break;

            root = stack.pop();
            root = root.right;
        }
    }


    private static void levelOrderTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            Node node = queue.poll();
            System.out.print(node.data + " ");

            if (nonNull(node.left))
                queue.add(node.left);
            if (nonNull(node.right))
                queue.add(node.right);
        }
    }

    private static void postOrderTraversalUsingTwoStack(Node root) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();


        if (root == null)
            return;

        s1.push(root);

        while (!s1.isEmpty()) {
            Node temp = s1.pop();
            s2.push(temp);

            if (temp.left != null)
                s1.push(temp.left);
            if (temp.right != null)
                s1.push(temp.right);
        }

        while (!s2.isEmpty()) {
            Node temp = s2.pop();
            System.out.print(temp.data + " ");
        }
    }

    private static void inOrderTraversal(Node root) {
        Stack<Node> stack = new Stack<>();

        while (true) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.empty())
                break;

            root = stack.pop();

            System.out.print(root.data + " ");
            root = root.right;
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

        @Override
        public String toString() {
            return "Node{" +
                    "left=" + left +
                    ", right=" + right +
                    ", data=" + data +
                    '}';
        }
    }
}
