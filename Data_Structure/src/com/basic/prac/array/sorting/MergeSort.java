package com.prac.array.sorting;



// Stable Sorting algorithm O(nlogn)
public class MergeSort {

    int array[];
    int length;
    int tempArray[];

    public static void main(String[] args) {

        int[] arrayToSort = {43, 25};

        MergeSort mergeSort = new MergeSort();
        mergeSort.start_merge(arrayToSort);

        for (int i : arrayToSort) {
            System.out.print(i + " ");
        }
    }

    private void start_merge(int[] arrayToSort) {

        this.array = arrayToSort;
        this.length = array.length - 1;
        this.tempArray = new int[arrayToSort.length];

        merge_sort(0, length);
    }

    private void merge_sort(int low, int high) {

        if (low < high) {
            int mid = (low + high) / 2;

            merge_sort(low, mid);
            merge_sort(mid + 1, high);
            merge(low, mid, high);
        }
    }

    private void merge(int low, int mid, int high) {

        for (int i = low; i <= high; i++)
            tempArray[i] = array[i];

        int i = low;
        int j = mid + 1;
        int k = low;

        while (i <= mid && j <= high) {

            if (tempArray[i] <= array[j]) {
                array[k] = tempArray[i];
                i++;
            } else {
                array[k] = tempArray[j];
                j++;
            }

            k++;
        }

        while (i <= mid) {

            array[k] = tempArray[i];
            k++;
            i++;
        }
    }

}