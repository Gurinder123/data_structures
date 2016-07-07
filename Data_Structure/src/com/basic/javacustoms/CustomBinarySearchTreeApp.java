package com.basic.javacustoms;

/**
 * Created by gurinder on 8/7/16.
 */
public class CustomBinarySearchTreeApp {

    public static void main(String[] args) {
        CustomBinarySearchTree<Integer> binarySearchTree = new CustomBinarySearchTree();
        binarySearchTree.insert(2);
        binarySearchTree.insert(3);
        binarySearchTree.insert(-1);
        binarySearchTree.insert(-1);
        binarySearchTree.display();
    }

}

class CustomBinarySearchTree<E> {

    TreeNode<E> root;


    class TreeNode<E> {
        private E element;
        TreeNode<E> leftChild;
        TreeNode<E> rightChild;

        public TreeNode(E element) {
            this.element = element;
            leftChild = null;
            rightChild = null;
        }

        public TreeNode() {
        }


    }

    public CustomBinarySearchTree() {

    }

    public void insert(E data) {
        TreeNode<E> newEntry = new TreeNode<>(data);
        if (root == null) {
            root = newEntry;
            return;
        }

        TreeNode<E> current = root, parent = null;

        while (true) {
            parent = current;
            if (compare(data, current.element)) {
                current = current.leftChild;
                if (current == null) {
                    parent.leftChild = newEntry;
                    return;
                }
            } else {
                current = current.rightChild;
                if (current == null) {
                    parent.rightChild = newEntry;
                    return;
                }
            }
        }

    }

    public void display(TreeNode<E> e) {
        if (e != null) {
            display(e.leftChild);
            System.out.print(" " + e.element);
            display(e.rightChild);
        }
    }

    public void display() {
        this.display(root);
    }


    private boolean compare(Object element, Object data) {
        E e1 = (E) element;
        E e2 = (E) data;
        if (e1 instanceof Integer && e2 instanceof Integer) {
            Integer i1 = (Integer) e1;
            Integer i2 = (Integer) e2;
            return i1 < i2;
        }
        return false;
    }
}

