package com.basic;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by gurinder on 1/9/16.
 */

class Person {
    private String fName;
    private String lName;
    private int age;

    public Person(String fName, String lName, int age) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        Person person = (Person) o;
        return this.fName.equals(person.lName);

    }

    @Override
    public int hashCode() {
        int result = fName != null ? fName.hashCode() : 0;
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", age=" + age +
                '}';
    }
}

public class HashPractice {
    public static void main(String[] args) {
        Person p1 = new Person("Arjun", "Bheem", 15);
        Person p2 = new Person("Arjun", "haha", 15);
        Set set = new HashSet<>();
        set.add(p1);
        System.out.println("Before: " + set);
        set.add(p2);
        System.out.println("Now: " + set);

    }
}
