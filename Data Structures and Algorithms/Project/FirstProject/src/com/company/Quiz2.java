package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Quiz2 {
    static int r = 10;
    static int c = 10;
    static int[] x = { -1, -1, -1,-1, 0, 0, 1, 1, 1 ,1};
    static int[] y = {0, -1, 0, 1, -1, 1, -1, 0, 1 ,0};

    public static void main(String[] args) throws IOException {
        char[][] arr2D = new char[][]{{'E','T' ,'Q', 'I' ,'C', 'A' ,'T' ,'R' ,'O' ,'D'},{'L', 'W', 'T', 'P', 'R', 'O', 'P', 'E' ,'R' ,'A'},{'E' ,'I' ,'A' ,'R' ,'B' ,'C' ,'L' ,'A', 'S' ,'S'},{'F', 'T','O', 'Z', 'W' ,'V', 'A', 'N', 'Q' ,'S'},{'A' ,'E' ,'Q', 'N', 'S', 'P', 'D', 'F', 'S', 'A'},{'E' ,'A' ,'D', 'G', 'R' ,'E' ,'Y' ,'I' ,'S','I'},{'A' ,'S' ,'A' ,'S' ,'D' ,'O' ,'S' ,'D' ,'A' ,'M'},{'R' ,'A' ,'G' ,'J' ,'P' ,'H' ,'Q', 'W', 'E', 'E'},{'G' ,'H' ,'J', 'T', 'Q', 'E', 'E' ,'E' ,'Q' ,'W'},{'H' ,'Z', 'X' ,'D' ,'R' ,'E' ,'E' ,'F' ,'Y', 'W'}};
        String search = "PROPER";
        Search2D(arr2D,search);
    }

    static void Search2D(char arr2D[][],String search){
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                if ((arr2D[i][j] == search.charAt(0))){
                    if(search2D(arr2D, search, i, j)){
                        System.out.print(i +""+j);
                        break;
                    }
                }


    }

    static boolean search2D(char[][] grid, String word,int row, int col) {
        int len = word.length();
        int TogoCol ,TogoRow;

        for (int firstLoop = 0; firstLoop < 8; firstLoop++) {
            switch (firstLoop) {
                case 0:
                    TogoRow = 1+row;
                    TogoCol = col;
                    break;
                case 1:
                    TogoRow = row - 1;
                    TogoCol = col;
                    break;
                case 2:
                    TogoRow = row;
                    TogoCol = col+1;
                    break;
                case 3:
                    TogoRow = row;
                    TogoCol = col-1;
                    break;
                case 4:
                    TogoRow = row+1;
                    TogoCol = col+1;
                    break;
                case 5:
                    TogoRow = row+1;
                    TogoCol = col-1;
                    break;
                case 6:
                    TogoRow = row-1;
                    TogoCol = col+1;
                    break;
                case 7:
                    TogoRow = row-1;
                    TogoCol = col-1;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + firstLoop);
            }
            
            if(grid[TogoRow][TogoCol] == word.charAt(1)){
                for (int i = 2; i < len; i++) {
                    
                }
            }
        }
        return false;
    }
}
