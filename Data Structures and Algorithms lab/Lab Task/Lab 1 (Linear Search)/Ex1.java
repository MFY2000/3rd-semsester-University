package com.company;

import java.util.Scanner;

public class Ex1 {

    public static void main(String[] args) {
        // program 1
        int a[] = {8,9,6,4,10,5};
        int key = 5;
        int i;
        boolean flag = true;
        for(i = 0; i< a.length; i++){
            if(key == a[i]){
                flag = true;
                break;
            }
        }

        System.out.println("The key"+(!flag ? " not found":" found at "+i)+" in the array");

        // program 2

        System.out.print("\n\nProgram 1");


        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int arrayLength = myObj.nextInt();
        int arr2[] = new int[arrayLength];

        for(i = 0; i<arrayLength;i++){
            System.out.print("Enter the value of "+i+1+" index: ");
            arr2[i] = myObj.nextInt();
        }

        System.out.print("Enter the value you wants to Search: ");
        key = myObj.nextInt();


        flag = true;
        for(i = 0; i< arrayLength; i++){
            if(key == a[i]){
                flag = true;
                break;
            }
        }

        System.out.println("The key"+(!flag ? " not found":" found at "+i)+" in the array");



    }
}
