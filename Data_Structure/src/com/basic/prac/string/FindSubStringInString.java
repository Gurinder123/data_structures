package com.prac.string;

import java.util.*;

public class FindSubStringInString {

    class Employee{

        private String name;
        private int age;

        public Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return age == employee.age &&
                    Objects.equals(name, employee.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();

        FindSubStringInString str = new FindSubStringInString();
        employeeList.add(str.new Employee("Gurinder", 27));
        employeeList.add(str.new Employee("Akul", 22));
        employeeList.add(str.new Employee("Pulkit", 29));

        System.out.println(employeeList);

        Collections.sort(employeeList, Comparator.comparing(e -> e.age));

        System.out.println(employeeList);


        String string = "gurinder singh";
        String pattern = "ring";

        int stringLength = string.length();
        int patternLength = pattern.length();

        if (patternLength > stringLength) {
            System.out.println("No window exist");
            return;
        }

        int hash_pattern[] = new int[256];
        int hash_string[] = new int[256];


        for (int i = 0; i < patternLength; i++)
            hash_pattern[pattern.charAt(i)]++;


        int start_index = -1;
        int count = 0;
        int min_length = Integer.MAX_VALUE;
        int start = 0;
        for (int j = 0; j < stringLength; j++) {

            hash_string[string.charAt(j)]++;

            if (hash_pattern[string.charAt(j)] != 0 && hash_string[string.charAt(j)] <=
                    hash_pattern[string.charAt(j)])
                count++;

            if (count == patternLength) {
                while (hash_string[string.charAt(start)] >
                        hash_pattern[string.charAt(start)]) {
                    hash_string[string.charAt(start)]--;
                    start++;
                }

                int current_min_len = j - start + 1;

                if (min_length > current_min_len) {
                    min_length = current_min_len;
                    start_index = start;
                }
            }

        }

        System.out.println("Start index:" + start_index + " end index:" + (start_index + min_length));
        System.out.println(string.substring(start_index, start_index + min_length));

    }
}
