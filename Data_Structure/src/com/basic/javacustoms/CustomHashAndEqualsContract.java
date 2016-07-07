package com.basic.javacustoms;

import java.util.*;

/**
 * Created by gurinder on 22/6/16.
 */
public class CustomHashAndEqualsContract {
    public static void main(String[] args) {
        Set<Employee> employeeSet = new HashSet<>();
        employeeSet.add(new Employee(1, "Gurinder", "xi309"));
        employeeSet.add(new Employee(1, "Gurinder", "xi309Real"));
        employeeSet.add(new Employee(2, "Harsh", "xi308"));
        employeeSet.add(new Employee(3, "Anshul", "xi310"));
        employeeSet.add(new Employee(4, "Jassi", "xi307"));
        employeeSet.add(new Employee(5, "Kohli", "xi305"));

        TreeSet<Employee> emTreeSet = new TreeSet(new EmployeeSorter());
        emTreeSet.addAll(employeeSet);

        Map<String, Employee> map = new HashMap<>();
        Employee e1 = new Employee(1, "Gurinder Singh", "XI309");
        map.computeIfAbsent("Gurinder", s -> e1);
        map.computeIfAbsent("Gurinder", s -> new Employee(2, "Gurinder Singh", "XI309"));

        System.out.println(map);
        Set<Map.Entry<String, Employee>> entries = map.entrySet();
        entries.stream().filter(stringEmployeeEntry -> stringEmployeeEntry.getKey().equals("Gurinder")).forEach(System.out::print);
    }


}

class EmployeeSorter implements Comparator<Employee> {


    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getId() - o2.getId();
    }
}

class Employee {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", empId='" + empId + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result = 31 * id;
        result = result + (getName() != null ? getName().hashCode() : 0);
        result = result + (getEmpId() != null ? getEmpId().hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (getId() != employee.getId()) return false;
        if (getName() != null ? !getName().equals(employee.getName()) : employee.getName() != null) return false;
        return !(getEmpId() != null ? !getEmpId().equals(employee.getEmpId()) : employee.getEmpId() != null);

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    private String empId;

    public Employee(int id, String name, String empId) {
        this.id = id;
        this.name = name;
        this.empId = empId;
    }


}
