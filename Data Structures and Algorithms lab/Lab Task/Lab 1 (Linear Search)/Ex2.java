package com.company.LabTask.Lab1_(Linear_Search);

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        System.out.print("\n\nProgram 2");
        int i;
        int max;
        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int arrayLength = myObj.nextInt();
        int arr2[] = new int[arrayLength];

        for(i = 0; i<arrayLength;i++){
            System.out.print("Enter the value of "+i+1+" index: ");
            arr2[i] = myObj.nextInt();
        }

        max = arr2[0];
        for(i = 0; i< arrayLength; i++){
            if(max < arr2[i]){
                max = arr2[i];
            }
        }

        System.out.println("The largest Value is "+max+" in the array");


    }
}
