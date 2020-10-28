package com.company;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        System.out.print("\n\nProgram 3");
        int i;
        int sum = 0;
        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int arrayLength = myObj.nextInt();
        int arr2[] = new int[arrayLength];

        for(i = 0; i<arrayLength;i++){
            System.out.print("Enter the value of "+i+1+" index: ");
            arr2[i] = myObj.nextInt();
        }

        for(i = 0; i< arrayLength; i++){
            sum += arr2[i];
        }

        System.out.println("The Sum of all the values is "+sum+" in the array");


    }
}
