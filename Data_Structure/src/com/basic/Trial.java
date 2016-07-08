package com.basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Gurinder on 7/8/2016.
 */
public class Trial {
    public static void main(String[] args) {
        Pattern pt = Pattern.compile("Sun certified java programmer");
        Matcher mt =pt.matcher("certified");
        mt.find();
        System.out.println(mt.group());
    }
}
//prseomctest
