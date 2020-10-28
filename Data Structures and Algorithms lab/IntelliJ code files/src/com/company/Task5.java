//3)	Write a program to find the occurrence of the key in the array?

package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        int i, key;
        boolean flag = false;

        System.out.print("5) Write a program in which user will input the array and the key for searching?\n");

        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int arrayLength = myObj.nextInt();
        int Array[] = new int[arrayLength];

        for(i = 0; i<arrayLength;i++){
            System.out.print("Enter the value of "+i+" index: ");
            Array[i] = myObj.nextInt();
        }

        System.out.print("Enter the value you wants to Search: ");
        key = myObj.nextInt();


        System.out.println("\nThe Array is: "+ Arrays.toString(Array));
        System.out.println("Key to found: "+key+"\n");

        for(i = 0; i< arrayLength; i++){
            if(key == Array[i]){
                flag = true;
                break;
            }
        }

        System.out.println("The key"+(!flag ? " not found":" found at index: "+i)+" in the array");

    }
}
