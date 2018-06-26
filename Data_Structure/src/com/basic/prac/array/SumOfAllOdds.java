package com.prac.array;

/**
 * 21 = 1 + 3 + 7 + 21 = 32
 * 10 = 1 + 5 = 6
 */
public class SumOfAllOdds {

    public static void main(String[] args) {

        int ar[] = {1, 2, 3, 2, 2, 3, 2};

        System.out.println(birthdayCakeCandles(ar));
    }

    static int birthdayCakeCandles(int[] ar) {

        int start = 0;
        int end = ar.length - 1;

        int left = 0;
        int right = 0;
        int count = 0;

        while (start <= end) {

            if (ar[start] >= left) {
                left = ar[start];
                count++;
            }

            if (ar[end] >= right) {
                right = ar[end];
                count++;
            }

            if (left == 0 && start >= 0) {
                count++;
            }

            start++;
            end--;
        }

        return count;
    }


    private static long getSum(int val) {

        long sum = 1;

        for (int i = 2; i <= val / 2; i++) {
            if (val % i == 0 && i % 2 == 1)
                sum += i;
        }

        if ((sum > 1 || (val > 1 && val < 4)) && val % 2 == 1) {
            sum = sum + val;
        }

        return sum;
    }
}
