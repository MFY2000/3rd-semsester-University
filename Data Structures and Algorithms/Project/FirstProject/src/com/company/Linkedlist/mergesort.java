package com.company.Linkedlist;

import java.util.Arrays;

public class mergesort {
    private static int i= 0;
    static void merge(int A[] , int start, int mid, int end) {
        int low = start, middle = mid+1, count = 0;
        int temp[] = new int[(end-start)+1];

        i++;

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

    static void sort(int arr[],int low,int high,String name){
        System.out.println(name+"("+i+")");

        int mid;
        if(low < high){
            mid=(low+high)/2;

            sort(arr,low,mid,name+"<-left");
            sort(arr,mid+1,high,name+"->right");

            merge(arr,low,mid,high);
        }
    }

    public static void main(String[] args) {
        int temp[] = {8,5,6,21,85,8,1,88,39,55,180};
        int low = 0;
        int high = temp.length-1;
        System.out.println("Non sorted: "+Arrays.toString(temp));

        sort(temp,low,high,"Main");

        System.out.println("Sorted: "+Arrays.toString(temp));
    }
}