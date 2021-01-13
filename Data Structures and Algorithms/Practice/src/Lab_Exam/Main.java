package Lab_Exam;

import Lab_Exam.Search.Binary;
import Lab_Exam.Search.Linear;
import Lab_Exam.Sorting.Bubble;
import Lab_Exam.Sorting.Insertion;
import Lab_Exam.Sorting.Selection;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{7, 98, 6, 12, 84, 2, 68, 8,84,84,55};

        Selection Search = new Selection(array);
        System.out.println(Search.toString());

    }
}
