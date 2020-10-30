package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BubbleSorting3 {
    public static void main(String[] args) throws IOException {
        int length,size,i,j;
        String temp[];

        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        temp = scan.readLine().split(" ");

        length = Integer.parseInt(temp[0]);
        size = Integer.parseInt(temp[1]);

        String UserInput[][] = new String[length][size];

        for (i = 0; i < length; i++) {
            temp = scan.readLine().split(" ");
            for (j = 0; j < size; j++) {
                UserInput[i][j] = temp [j];
            }
        }


        for (i = 0; i < length-1; i++) {
            for (j = 0; j < (length-i)-1; j++) {

                boolean match = (Integer.parseInt(UserInput[j][size-1])) <  (Integer.parseInt(UserInput[j+1][size-1]));
                boolean match2 = ((Integer.parseInt(UserInput[j][size-1])) == (Integer.parseInt(UserInput[j+1][size-1]))) && (UserInput[j][0].charAt(0) > UserInput[j+1][0].charAt(0));

                if (match || match2) {
                    temp = UserInput[j];
                    UserInput[j] = UserInput[j+1];
                    UserInput[j+1] = temp;
                }

//                else if (match2){
//                    temp = UserInput[j];
//                    UserInput[j] = UserInput[j+1];
//                    UserInput[j+1] = temp;
//                }

            }
        }

        for (i = 0; i < 2; i++) {
            System.out.println(UserInput[i][0]);
        }
    }
}