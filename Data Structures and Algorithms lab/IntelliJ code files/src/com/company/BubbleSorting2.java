package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSorting2 {
    public static void main(String[] args) {
        System.out.println("2) Implement Bubble Sort for descending order.\n");

        int length;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the Length of the array: ");
        length = scan.nextInt();
        int arr[] = new int[length];

        for (int i = 0; i < length; i++) {
            System.out.print("Enter the Value of index: "+i+" : ");
            arr[i] = scan.nextInt();
        }

        System.out.println("\nArray before descending order bubble sorting: "+ Arrays.toString(arr));

        int swap;
        for (int i = 0; i < length-1; i++) {
            for (int j = 0; j < (length-i)-1; j++) {
                if (arr[j] < arr[j+1]) {
                    swap = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = swap;
                }
            }
        }

        System.out.println("\nArray After descending order bubble sorting: "+ Arrays.toString(arr));

    }
}
