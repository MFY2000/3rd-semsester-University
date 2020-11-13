package com.company.Sorting;

import java.util.Arrays;

public class mergesort {
    static void merge(int A[ ] , int start, int mid, int end) {
        int low = start, middle = mid+1, count=0;
        int temp[] = new int[(end-start)+1];

        while (low<=mid&&middle<=end){
           if (A[low] < A[middle])
               temp[count] = A[low++];

            else
                temp[count] = A[middle++];

            count++;
        }

        while(low<=mid)
            temp[count++] = A[low++];

        while(middle<=end)
            temp[count++] = A[middle++];


        for (int i = 0; i<count; i++,start++)
              A[start] = temp[i];

    }

    static void sort(int arr[],int low,int high){
        int mid;
        if(low < high){
            mid=(low+high)/2;

            sort(arr,low,mid);
            sort(arr,mid+1,high);

            merge(arr,low,mid,high);
        }
    }

    public static void main(String[] args) {
        int[] arr={4,8,3,1,6,7};
        int low = 0;
        int high = arr.length-1;
        System.out.println("Non sorted: "+Arrays.toString(arr));

        sort(arr,low,high);

        System.out.println("Sorted: "+Arrays.toString(arr));
    }
}