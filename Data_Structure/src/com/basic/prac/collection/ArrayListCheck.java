package com.prac.collection;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

class A{

     protected static void master(){

    }

}

public class ArrayListCheck extends A{

    protected static void master(){

    }

    public static void main(String[] args) {

        System.out.println(Math.abs(1));

    }

    private static void printWithoutLoop(int val) {
        if (val < 0)
            return;
        else {
            printWithoutLoop(val - 1);
            System.out.println(val);
        }

    }

    static class Student {
        private String name;
        private int height;
        private String fName;

        public Student(String name, int height) {
            this.name = name;
            this.height = height;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;

            Student student = (Student) o;

            if (getHeight() != student.getHeight()) return false;
            if (getName() != null ? !getName().equals(student.getName()) : student.getName() != null) return false;
            return fName != null ? fName.equals(student.fName) : student.fName == null;
        }

        @Override
        public int hashCode() {
            int result = getName() != null ? getName().hashCode() : 0;
            result = 31 * result + getHeight();
            result = 31 * result + (fName != null ? fName.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", height=" + height +
                    '}';
        }
    }
}
