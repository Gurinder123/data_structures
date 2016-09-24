package com.basic;

/**
 * Created by gurinder on 24/9/16.
 * Break your money into given coins
 */

public class CoinCount {
    //coins
    private static int a[] = {10, 5, 2, 1};

    public static void main(String[] args) {
        int money = 30;
        new CoinCount().breakMyMoney(money);
        money = 71;
        new CoinCount().breakMyMoney(money);
//another approach
        for (int num : a)
            money = breakMoney(money, num);
    }

    private static int breakMoney(int money, int num) {
        int count = 0;
        if (money >= num) {
            count = money / num;
            money = money % num;
        }
        System.out.println(num + " count=" + count);
        return money;
    }

    private void breakMyMoney(int money) {
        int tenCount = 0;
        int fiveCount = 0;
        int twoCount = 0;
        int oneCount = 0;
        if (money >= 10) {
            tenCount = money / 10;
            money = money % 10;
        }
        if (money >= 5) {
            fiveCount = money / 5;
            money = money % 5;
        }
        if (money >= 2) {
            twoCount = money / 2;
            money = money % 2;
        }
        if (money >= 1) {
            oneCount = money / 1;
        }
        System.out.println("ten=" + tenCount + " five=" + fiveCount + "" + " two=" + twoCount + " one=" + oneCount);
    }
}
