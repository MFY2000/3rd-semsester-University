package com.company;

import java.util.Arrays;

public class Ex1 {
    public static void main(String[] args) {

        System.out.println("1) Implement Binary Search to find the given key.");

        int sizeOfArray = 10;

        int arr[] = new int[sizeOfArray];

        for (int i = 0; i < sizeOfArray; i++) {
            arr[i] = i+1;
        }

        int LP = 0,
            RP = sizeOfArray-1,
            mid,
            key = 9,
            hit = 0;

        boolean flag = true;

        System.out.println("The array is: "+Arrays.toString(arr));
        System.out.println("The key is: "+key);

        while (LP<=RP){
            mid = (LP+RP)/2;

            if(key == arr[mid]){
                System.out.println("Key found at: "+mid+" index in the hit: "+hit);
                flag = false;
                break;
            }
            else if(arr[mid]<key){
                LP = mid+1;
            }
            else if(arr[mid]>key){
                RP = mid-1;
            }
            hit++;
        }
        if (flag){
            System.out.println("The key not found in the array in the hit: "+hit);
        }

    }
}
