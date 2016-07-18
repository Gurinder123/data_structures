package com.basic.javacustoms;

import java.util.*;

/**
 * Created by gurinder on 16/7/16.
 */
public class FetchAllFailingUrls {
    private static HashSet<String> hashSet = new HashSet<>();

    private static HashMap<String, List<String>> failureMap = new HashMap<>();

    public static void main(String[] args) {
        check("www.hello.com");
        System.out.println(failureMap);
    }

    public static void check(String str) {
        if (!hashSet.contains(str)) {
            hashSet.add(str);
            checkUrl(str);
        }
    }

    private static void checkUrl(String str) {
        List<String> urls = urls(str);
        List<String> failingUrls = new ArrayList<>();
        for (String url : urls) {
            if (!isWorking(url)) {
                failingUrls.add(url);
                check(url);
            }
        }
        failureMap.put(str, failingUrls);
    }

    private static List<String> urls(String str) {
        return new ArrayList<String>() {{
            add("link1");
            add("link2");
            add("link3");
        }};
    }

    private static boolean isWorking(String str) {
        int i = new Random().nextInt();
        return i % 2 == 0 ? true : false;
    }
}
