/*
2)	Write a program to find maximum & minimum number from an array?
 */

package com.company;
import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("2) Write a program to find maximum & minimum number from an array ?\n");

        int i;
        int max,min;
        Scanner myObj = new Scanner(System.in);

        System.out.print("Enter the length of the array: ");
        int arrayLength = myObj.nextInt();

        int Array[] = new int[arrayLength];

        for(i = 0; i < arrayLength; i++){
            System.out.print("Enter the value of "+i+" index: ");
            Array[i] = myObj.nextInt();
        }

        System.out.println("\nThe Array is: "+ Arrays.toString(Array));


        max = Array[0];
        min = Array[0];

        for(i = 0; i< arrayLength; i++){
            if(Array[max] < Array[i]){
                max = i;
            }
            else if(Array[min] > Array[i]){
                min = i;
            }
        }

        System.out.println("\nThe max Value is "+Array[max]+" at index: "+max+" in the array");
        System.out.println("The min Value is "+Array[min]+" at index: "+min+" in the array");


    }
}
