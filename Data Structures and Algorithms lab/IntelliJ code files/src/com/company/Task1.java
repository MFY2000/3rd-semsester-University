/*
program 1
Write a program to search a key linearly?
*/
package com.company;

import java.util.Arrays;
public class Task1 {
    public static void main(String[] args) {
        System.out.println("1) Write a program to search a key linearly?\n");

        int Array[] = {8,9,6,4,10,5};
        int key = 5;
        boolean flag = true;
        int i;

        System.out.println("The Array is: "+ Arrays.toString(Array));
        System.out.println("The Key is: "+key+"\n");

        for(i = 0; i< Array.length; i++){
            if(key == Array[i]){
                flag = true;
                break;
            }
        }

        System.out.println("The key"+(!flag ? " not found":" found at index:  "+i)+" in the array");
    }
}
