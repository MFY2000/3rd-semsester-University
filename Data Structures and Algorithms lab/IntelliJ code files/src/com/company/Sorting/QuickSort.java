package com.company.Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr={4,8,3,1,6,7};
        int low = 0;
        int high = arr.length-1;

        System.out.println("---------- Quick Sort ----------");
        System.out.println("Non sorted: "+ Arrays.toString(arr));

        sort(arr,low,high);

        System.out.println("Sorted: "+Arrays.toString(arr));
    }

    static void sort(int arr[], int low, int high){
        if (low < high){
            int pi = partition(arr, low, high);

            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }

    static int partition(int arr[], int low, int high){
        int pivot = arr[high];
        int i = (low-1); // index of smaller element

        for (int j=low; j<high; j++)
            if (arr[j] > pivot)
                i += swap(arr,i+1,j);

        return (i+swap(arr,i+1,high));
    }

    public static int swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return 1;
    }
}
