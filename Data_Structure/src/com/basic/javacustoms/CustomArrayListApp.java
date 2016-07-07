package com.basic.javacustoms;

import java.util.Arrays;

/**
 * Created by gurinder on 22/6/16.
 */
public class CustomArrayListApp {
    public static void main(String[] args) {
        CustomArrayList<Integer> arrayList = new CustomArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        System.out.println(arrayList.get(3));
    }
}

class CustomArrayList<V> {
    private static final int INTIAL_CAPACITY = 10;
    private Object myArray[];
    private static int count = 0;

    public CustomArrayList() {
        myArray = new Object[INTIAL_CAPACITY];
    }

    public void add(V data) {
        if (INTIAL_CAPACITY == myArray.length)
            ensureCapacity();
        myArray[count++] = data;
    }

    public V get(int index) {
        if (index < 0 || index >= myArray.length)
            throw new ArrayIndexOutOfBoundsException();

        if (count - 1 < index)
            throw new ArrayIndexOutOfBoundsException("index: " + index + " size: " + count);

        return (V) myArray[index];
    }

    private void ensureCapacity() {
        myArray = Arrays.copyOf(myArray, myArray.length * 2);
    }
}
