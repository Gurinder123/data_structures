package com.prac.stack;

public class LinkedListStack<T> {

    private LL<T> top;

    public static void main(String[] args) {

        LinkedListStack<Integer> stack = new LinkedListStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.print();

        stack.pop();

        stack.print();
    }

    private void pop() {
        if (top == null)
            System.out.println("Empty Stack");
        else {
            top = top.getNext();
        }
    }

    private void push(T t) {

        if (top == null) {
            top = new LL<>(t);
        } else {
            LL<T> newElement = new LL<>(t);
            newElement.setNext(top);
            top = newElement;
        }
    }


    private void print() {
        LL temp = top;
        while (temp != null) {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
    }

}


class LL<T> {

    private LL next;
    private T data;

    public LL(T data) {
        this.data = data;
    }

    public LL getNext() {
        return next;
    }

    public void setNext(LL next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}