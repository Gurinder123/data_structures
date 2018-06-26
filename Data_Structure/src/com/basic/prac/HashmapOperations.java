package com.prac;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

interface a<T>{
    default void master(String a){

    }


    void masterAgain(String a);

    void masterAgain(T a);

}

interface b extends a<String>{

    default void masterAgain(String a){

    }
}

public class HashmapOperations implements Comparable {

    public static void main(String[] args) {

        Optional<String> string = Optional.of("String");

    }

    static int findPivot(int arr[], int low, int high) {
        // base cases
        if (high < low)
            return -1;
        if (high == low)
            return low;

        /* low + (high - low)/2; */
        int mid = (low + high) / 2;

        if (mid < high && arr[mid] > arr[mid + 1])
            return mid;

        if (mid > low && arr[mid] < arr[mid - 1])
            return (mid - 1);

        if (arr[low] >= arr[mid])
            return findPivot(arr, low, mid - 1);

        return findPivot(arr, mid + 1, high);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }


    static class Employee implements Comparable<Employee> {
        private String name;
        private String id;

        public Employee(String name, String id) {
            this.name = name;
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            return false;
        }

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", id='" + id + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Employee o) {
            return o.name.compareTo(this.name);
        }
    }
}
