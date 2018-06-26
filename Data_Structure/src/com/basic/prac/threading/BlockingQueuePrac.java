package com.prac.threading;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.*;

public class BlockingQueuePrac {

    private static BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(3);

    public static void main(String[] args) {

        BigDecimal bigDecimal1 = new BigDecimal("1.00");
        BigDecimal bigDecimal2 = new BigDecimal("1");

        System.out.println(bigDecimal1.compareTo(bigDecimal2));
        System.out.println(bigDecimal1.equals(bigDecimal2));

    }

    static class Employee implements Comparable<Employee> {

        private String name;
        private int age;

        public Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public int compareTo(Employee employee) {
            return this.age - employee.age;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }


}

