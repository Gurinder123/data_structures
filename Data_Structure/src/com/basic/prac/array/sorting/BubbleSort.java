package com.prac.array.sorting;

// Stable Sorting algorithm O(n^2)
public class BubbleSort {

    int array[];

    public static void main(String[] args) {

        int[] arrayToSort = {43, 25, 1, 4, 5};

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.start_bubble(arrayToSort);

        for (int i : arrayToSort) {
            System.out.print(i + " ");
        }

    }

    private void start_bubble(int[] arrayToSort) {

        this.array = arrayToSort;

        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array.length; j++) {

                if (array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

    }
}
