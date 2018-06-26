package com.prac.collection;

import com.prac.LinkedHashMapOperations;
import sun.misc.Unsafe;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.*;

@MyLinkedHashMap.my(value = "Prototype")
public class MyLinkedHashMap<K, V> implements Cloneable{

    private Node head;

    private Node<K, V>[] node = (Node<K, V>[]) new Node[16];

    class Node<K, V> {
        public String str;
        private K key;
        private V value;
        private Node next;
        private Node prev;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public void setStr(String str) {
            this.str = str;
        }
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {


        Unsafe unsafe =Unsafe.getUnsafe();
        System.out.println(unsafe.addressSize());

    }

    @Target({ElementType.FIELD, ElementType.TYPE, ElementType.LOCAL_VARIABLE, ElementType.PACKAGE})
    @Retention(value = RetentionPolicy.RUNTIME)
    @interface my{
      String value() default "singleTon";
    }

    private void add(K key, V value) {

        if (head == null) {
            head = node[key.hashCode() % node.length] = new Node<>(key, value);
        } else {

            if (node[key.hashCode() % node.length] != null){

                Node<K, V> node = this.node[key.hashCode() % this.node.length];

                if (node.key.equals(key)){
                   node.value = value;
                   return;
                }

                while (node.next != null){
                    node = node.next;
                }

                Node newNode = new Node<>(key, value);
                newNode.prev = node;
                node.next = newNode;

            } else{

                Node temp = head;

                while (temp.next != null){
                    temp = temp.next;
                }

                Node newNode = node[key.hashCode() % node.length] = new Node<>(key, value);
                newNode.prev = temp;
                temp.next = newNode;
            }

        }

    }
}
