package com.company.Sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class mergesort {
    static void merge(int A[ ] , int start, int mid, int end) {
        //stores the starting position of both parts in temporary variables.
        int p = start, q = mid+1, k=0;
        int Arr[] = new int[(end-start)+1];

        for(int i = start; i <= end; i++) {
            if(p > mid)      //checks if first part comes to an end or not .
                Arr[ k++ ] = A[ q++] ;

            else if ( q > end)   //checks if second part comes to an end or not
                Arr[ k++ ] = A[ p++ ];

            else if( A[ p ] < A[ q ])     //checks which part has smaller element.
                Arr[ k++ ] = A[ p++ ];

            else
                Arr[ k++ ] = A[ q++];
        }
        for (p = 0; p< k ; p ++) {
   /* Now the real array has elements in sorted manner including both parts.*/
            A[ start++ ] = Arr[ p ] ;
        }
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
    static void test(){
        int[] arr={10,5,4,22,6,7,11,8,2,1,3,9};
        int low = 0;
        int high = arr.length-1;
        System.out.println("Non sorted");
        System.out.println(Arrays.toString(arr));
        sort(arr,low,high);
        System.out.println("Sorted: ");
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        mergesort.test();
    }
}