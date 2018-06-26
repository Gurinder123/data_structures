package com.prac.trickyProblems;


import java.util.*;

public class Dependencies {

    private static List<String> messages = new ArrayList<>();

    public void method(String txt){
        System.out.println(messages.hashCode());

        synchronized (messages){
            messages = new ArrayList<>();
            System.out.println(messages.hashCode());
        }
    }

    public static void main(String[] args) {

        String[][] str = {{"A", "B"}, {"A", "B"}, {"B", "C"}, {"C", "A"}, {"D", "C"}};

        Map<String, Set<String>> treeMap = new TreeMap<>();

        for (int i = 0; i < str.length; i++) {

            if (!treeMap.containsKey(str[i][0])) {

                HashSet set = new HashSet<>();
                set.add(str[i][1]);
                treeMap.put(str[i][0], set);
            } else {
                Set<String> set = treeMap.get(str[i][0]);
                set.add(str[i][1]);
            }
        }

        System.out.println(treeMap);

        printDependencies(treeMap);

    }

    private static void printDependencies(Map<String, Set<String>> treeMap) {

        for (Map.Entry<String, Set<String>> element : treeMap.entrySet()) {

            System.out.print("\nDependency of " + element.getKey() + " :");

            Set<String> values = element.getValue();

            for (String value : values) {
                System.out.print(value + " ");
                treeMap.get(value).stream().forEach(System.out::print);
            }
        }
    }
}
