package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        System.out.print("\n\nProgram 4");
        int i;
        int sum = 0;
        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int arrayLength = myObj.nextInt();
        int arr2[] = new int[arrayLength];

        for(i = 0; i<arrayLength;i++){
            System.out.print("Enter the value of "+(i+1)+" index: ");
            arr2[i] = myObj.nextInt();
        }

        Arrays.sort(arr2);
        System.out.print("Now the Array is: {");
        for (int temp : arr2){
            System.out.print(temp+", \b");
        }
        System.out.println("}");


        int mid = arrayLength/2;
        int seacrh, starting=0, ending = arrayLength,hit = 1;

        System.out.print("Enter the value you wants to Search: ");
        seacrh = myObj.nextInt();
	boolean flag = true;
        do {
            if(arr2[mid] == seacrh){
                System.out.println("The value found at "+hit+" hit or the index is: "+(mid));
flag = false;            
    break;
            }
            else if(arr2[mid] < seacrh){
                starting = mid + 1;
            }
            else {
                ending = mid - 1;
            }

            mid = (starting+ending)/2;
            hit++;
        }while(starting<= ending);


if(flag){
        System.out.println("The Sum of all the values is "+sum+" in the array");
}


    }
}
