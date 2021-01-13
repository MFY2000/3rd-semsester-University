package Lab_Exam;

import Lab_Exam.Linkedlist.*;
import Lab_Exam.Search.*;
import Lab_Exam.Sorting.*;

public class Main {
    public static void main(String[] args) {
        Double_linkList dList = new Double_linkList();
        //Add nodes to the list
        dList.insert(1);
        dList.insert(5);
        dList.insert(2);
        dList.insert(3);
        dList.insert(4);

        //Displays the nodes present in the list
        System.out.println(dList.toString());
    }
}
