package com.company.Sorting;

import java.util.Arrays;

public class Sekection {
    void SelectionSorting(int arr[]){
        int length = arr.length;
        int swap;
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < (length-1); i++) {
            int minIndex = i;
            for (int j = i+1; j < length; j++) {
                System.out.println("j = "+j+",minIndex = "+minIndex+",minValue = "+arr[minIndex]+",Check("+arr[j]+"<"+arr[minIndex]+") => "+(arr[j] < arr[minIndex]));
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = swap;
            System.out.println(Arrays.toString(arr));
            System.out.println("----------------------------------------- i = "+i+" Complete -----------------------------------------");
        }
    }

}
