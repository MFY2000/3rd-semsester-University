package Lab_Exam;

import Lab_Exam.Search.Binary;
import Lab_Exam.Search.Linear;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{7, 98, 6, 12, 84, 2, 68, 8,84,84,55};
        int key = 84;
        Binary Search = new Binary(array,key);
        System.out.println(Search.toString());

    }
}
