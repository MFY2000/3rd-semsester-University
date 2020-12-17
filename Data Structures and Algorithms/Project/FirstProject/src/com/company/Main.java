package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
}


class Test {
    public static void main(String args[])
    {
        // Creating object of the
        // class linked list
        LinkedList ll
                = new LinkedList();

        // Adding elements to the linked list
        ll.add("A");
        ll.add("B");
        ll.addLast("C");
        ll.addFirst("D");
        ll.add(2, "E");

        System.out.println(ll);


        ll.set(0, "B");
        ll.remove(3);
        ll.removeFirst();
        ll.removeLast();

        System.out.println(ll);


        ll.remove("B");
        ll.remove(3);
        ll.removeFirst();
        ll.removeLast();

        System.out.println(ll);
    }
}




// Java program to search
// a word in a 2D grid
//import java.io.*;
//        import java.util.*;
//
//class GFG {
//
//    // Rows and columns in the given grid
//    static int R, C;
//    // For searching in all 8 direction
//    static int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };
//    static int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };
//
//    // This function searches in all
//    // 8-direction from point
//    // (row, col) in grid[][]
//    static boolean search2D(char[][] grid, int row, int col, String word) {
//        if (grid[row][col] != word.charAt(0))
//            return false;
//
//        int len = word.length();
//
//        for (int dir = 0; dir < 8; dir++) {
//            int k, rd = row + x[dir], cd = col + y[dir];
//
//            for (k = 1; k < len; k++) {
//                if (rd >= R || rd < 0 || cd >= C || cd < 0)
//                    break;
//
//                // If not matched, break
//                if (grid[rd][cd] != word.charAt(k))
//                    break;
//
//                rd += x[dir];
//                cd += y[dir];
//            }
//
//            if (k == len)
//                return true;
//        }
//        return false;
//    }
//
//    static void patternSearch(char[][] grid, String word)
//    {
//        for (int row = 0; row < R; row++) {
//            for (int col = 0; col < C; col++) {
//                if (search2D(grid, row, col, word))
//                    System.out.print(row +""+col);
//            }
//            System.out.println("");
//        }
//    }
//
//    public static void main(String args[])
//    {
//        R = 3;
//        C = 13;
//        char[][] grid = { { 'G', 'E', 'E', 'K', 'S', 'F', 'O', 'R', 'G', 'E', 'E', 'K', 'S' },
//                { 'G', 'E', 'E', 'K', 'S', 'Q', 'U', 'I', 'Z', 'G', 'E', 'E', 'K' },
//                { 'I', 'D', 'E', 'Q', 'A', 'P', 'R', 'A', 'C', 'T', 'I', 'C', 'E' } };
//        patternSearch(grid, "GEEKS");
//        System.out.println();
//    }
//}
