package com.company;

import java.util.Arrays;

public class Quicksort {
    public static void main(String[] args) {
            int temp[] = {8,5,6,21,85,8,1,88,39,55,180};
        int low = 0;
        int high = temp.length-1;

        System.out.println("---------- Quick Sort ----------");
//        System.out.println("Input: "+ Arrays.toString(temp));
        sort(temp,low,high,"Main");
//        System.out.println("Sorted: "+ Arrays.toString(temp));
    }

    static void sort(int arr[], int low, int high,String name){
        System.out.println(name);

        if (low < high){
            int pi = partition(arr, low, high);
            System.out.println(Arrays.toString(arr)+","+low+","+high+","+arr[pi]+",");

            sort(arr, low, pi-1,name+"<-left");
            sort(arr, pi+1, high,name+" -> right");
        }
    }

    static int partition(int arr[], int low, int high){
        int pivot = arr[high];
        int i = (low-1); // index of smaller element

        for (int j=low; j<high; j++)
            if (arr[j] < pivot)
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
