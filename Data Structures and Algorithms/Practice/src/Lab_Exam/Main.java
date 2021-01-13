package Lab_Exam;

import Lab_Exam.Search.*;
import Lab_Exam.Sorting.*;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{7, 98, 6, 12, 84, 2, 68, 8,84,84,55};

        Quick Search = new Quick(array);
        System.out.println(Search.toString());

    }
}
