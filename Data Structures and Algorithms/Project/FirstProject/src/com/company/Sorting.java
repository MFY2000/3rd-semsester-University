package com.company;

import java.util.Arrays;

class Sorting {

    void SelectionSorting(int arr[]) {
        int length = arr.length,
                swap,
                countloop = 0;
        System.out.println("----------------------------------------- Selection Sorting ----------------------------------------- ");
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < (length - 1); i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                System.out.println("j = " + j + ",minIndex = " + minIndex + ",minValue = " + arr[minIndex] + ",Check(" + arr[j] + "<" + arr[minIndex] + ") => " + (arr[j] < arr[minIndex]));
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
                countloop++;
            }
            swap = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = swap;
            System.out.println("----------------------------------------- i = " + i + " Complete -----------------------------------------");
            System.out.println(Arrays.toString(arr));

        }

        System.out.println("Number of time value inner loop works: " + countloop);
    }

    
}
