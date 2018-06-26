package com.prac.array.sorting;

public class InsertionSort {

    public static void main(String[] args) {

        int[] arrayToSort = {43, 25, 1, 4, 5};

        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertion_sort(arrayToSort);
    }

    private void insertion_sort(int[] arrayToSort) {

        for (int i = 1 ; i < arrayToSort.length ; i++){

            int key = arrayToSort[i];
            int j = i - 1;

            while(j > 0 &&  key < arrayToSort[j]){

                arrayToSort[i] =
                j--;
            }

        }
    }
}
