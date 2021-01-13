package Lab_Exam;

import Lab_Exam.Search.Binary;
import Lab_Exam.Search.Linear;
import Lab_Exam.Sorting.Bubble;
import Lab_Exam.Sorting.Insertion;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{7, 98, 6, 12, 84, 2, 68, 8,84,84,55};

        Insertion Search = new Insertion(array);
        System.out.println(Search.toString());

    }
}
