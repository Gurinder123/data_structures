package com.basic;

/**
 * Created by Gurinder on 7/8/2016.
 */
public class UrlShortener {

    private static String key = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private static  Map<Long, String> urlMap = new HashMap<>();

    public static void main(String[] args) {
        String url = "https://docs.spring.io/spring/docs/2.5.x/reference/aop.html";


        long id = 12345;

        urlMap.put(id, url);

        String shortUrl = idToShortUrl(id);

        id = shortUrlToId(shortUrl);

        System.out.println(urlMap.get(id));
    }

      private static long shortUrlToId(String url) {
        long id = 0;

        for (int i = 0; i < url.length(); i++) {
             id = id * 62 + key.indexOf(url.charAt(i));
        }

        return id;
    }

    private static String idToShortUrl(long id) {
        StringBuilder builder = new StringBuilder();

        while (id > 0) {
            builder.append(key.charAt((int)id % 62));
            id = id / 62;
        }

        return builder.reverse().toString();
    }
}
