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
                i += swap(arr,i,j);

        return (i+swap(arr,i,high));
    }

    public static int swap(int arr[], int i, int j) {
        int temp = arr[i+1];
        arr[i+1] = arr[j];
        arr[j] = temp;

        return 1;
    }
}

class quick_sort{
    static int partition(int[] arr,int low,int high){
        int pivot = arr[low];
        int i=(low-1),j=high,temp;
        do{
            while(i<high && arr[++i] <= pivot)

            while(arr[j] > pivot){
                j--;
            }
            if(i<j){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }while(i<j);
        temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }
    static void sort(int[] arr,int low,int high){
        if(low < high){
            int partition = partition(arr,low,high);

            sort(arr,low,partition-1);
            sort(arr,partition+1,high);
        }
    }
    static void test(){
        int arr1[] = {5,4,3,2,1};


        System.out.println("Non sorted: "+ Arrays.toString(arr1));

        sort(arr1,0,4);
        // merge(arr1,0,2,4);

        System.out.println("Sorted: "+ Arrays.toString(arr1));

    }
    public static void main(String[] args) {
        //      quick_sort object_1 = new quick_sort();
        quick_sort.test();
    }
}



