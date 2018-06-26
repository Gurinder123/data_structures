package com.prac.threading;

import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolExecutorSample {
    public static void main(String[] args) {
//        Executor executor = Executors.newFixedThreadPool(2);
//        executor = Executors.newWorkStealingPool()

        int count = Runtime.getRuntime().availableProcessors();

        System.out.println(count);
    }
}

class Employee{

    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int hashCode(){
        return name.hashCode();
    }

    public boolean equals(Object o){
        Employee employee = (Employee) o;

        return this.name.equals(employee.name);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
