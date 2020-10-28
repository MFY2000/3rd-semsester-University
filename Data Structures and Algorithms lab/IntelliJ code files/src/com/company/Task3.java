package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("3)\tWrite a program to find the occurrence of the key in the array?\n");

        boolean flag = true;
        int i,count=0;

        Scanner myObj = new Scanner(System.in);

        System.out.print("Enter the length of the array: ");
        int arrayLength = myObj.nextInt();

        int Array[] = new int[arrayLength];

        for(i = 0; i < arrayLength; i++){
            System.out.print("Enter the value of "+i+" index: ");
            Array[i] = myObj.nextInt();
        }

        System.out.print("Enter the value you wants to Search: ");
        int key = myObj.nextInt();

        System.out.println("\nThe Array is: "+ Arrays.toString(Array));

        for(i = 0; i< Array.length; i++){
            if(key == Array[i]){
                count++;
                flag = true;
            }
        }

        System.out.println("The key "+(!flag ? "not": count+" time ")+"occurrence in the array");



    }
}
