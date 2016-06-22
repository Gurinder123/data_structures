package com.basic;

/**
 * Created by gurinder on 6/6/16.
 */
public class HundredObject {
    static int count = 0;

    public static HundredObject getHundredObject() {
        if (count < 10) {
            count++;
            return new HundredObject();
        } else
            return null;

    }

}

class Another {
    public static void main(String[] args) {
        int count = 0;
        for (HundredObject hundredObject = HundredObject.getHundredObject(); hundredObject != null; hundredObject = HundredObject.getHundredObject()) {
            System.out.println(hundredObject + " " + (++count));
        }
    }
}
