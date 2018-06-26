package com.prac.threading;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

final public class PerfectlyImmutable implements Comparable<PerfectlyImmutable> {

    private final String fName;
    private final String lName;
    private final int age;

    public PerfectlyImmutable(String fName, String lName, int age) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public int getAge() {
        return age;
    }

    public int hashCode() {

        int result = 1;
        int prime = 31;

        result = result + prime * (this.age == 0 ? 0 : this.age);
        result = result + prime * (this.fName == null ? 0 : this.fName.hashCode());
        result = result + prime * (this.lName == null ? 0 : this.lName.hashCode());

        return result;
    }

    @Override
    public String toString() {
        return "PerfectlyImmutable{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", age=" + age +
                '}';
    }

    public boolean equals(Object o) {

        if (this == o)
            return true;

        if (!(o instanceof PerfectlyImmutable))
            return false;

        PerfectlyImmutable that = (PerfectlyImmutable) o;

        boolean fNameEqual = this.fName != null ? this.fName.equals(that.fName) : that.fName == null;
        boolean lNameEqual = this.lName != null ? this.lName.equals(that.lName) : that.lName == null;

        if (!fNameEqual || !lNameEqual)
            return false;

        return this.age == that.age;
    }


    public static void main(String[] args) {

        PerfectlyImmutable perfectlyImmutable1 = new PerfectlyImmutable("Gurinder", "Singh", 27);
        PerfectlyImmutable perfectlyImmutable2 = new PerfectlyImmutable("Yogendra", "Mishra", 26);
        PerfectlyImmutable perfectlyImmutable3 = new PerfectlyImmutable("Akul", "Goyal", 25);
        PerfectlyImmutable perfectlyImmutable4 = new PerfectlyImmutable("Akul", "Badrinath", 25);

        Map<PerfectlyImmutable, String> perfectlyImmutableStringMap = new HashMap<>();

        perfectlyImmutableStringMap.put(perfectlyImmutable1, "First");
        perfectlyImmutableStringMap.put(perfectlyImmutable2, "Second");
        perfectlyImmutableStringMap.put(perfectlyImmutable3, "Third");
        perfectlyImmutableStringMap.put(perfectlyImmutable4, "Fourth");


        TreeMap<PerfectlyImmutable, String> perfectlyImmutableStringTreeMap = new TreeMap<>(perfectlyImmutableStringMap);

        System.out.println(perfectlyImmutableStringTreeMap);
    }

    @Override
    public int compareTo(PerfectlyImmutable o) {

        if (this.equals(o))
            return 0;

        int result = this.fName.compareTo(o.fName);

        if (result == 0) {

            result = this.lName.compareTo(o.lName);
            if (result == 0)
                return this.age - o.age;

            return result;
        }

        return result;
    }
}
