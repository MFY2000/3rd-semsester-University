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


class BubbleSortdes {
    public static void main(String[] args) {
        int []array={3,5,7,4,2,9,1,8,6};
        int i,j;
        int temp=0;
        for(i=0; i<array.length-1; i++ ){
            for(j=0; j<(array.length-i)-1; j++){
                if (array[j] < array[j+1])
                {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }

            }
        }
        for (i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
    }
}