package com.company.Linkedlist;

public class Question4 {
    public static void main(String[] args) {
        Linkedlist list = new Linkedlist();

        list.insert(list, 1); // Q3
        list.insertAtstart(list, 2); //Q4
        list.insertBykey(list, 5,2); //Q5 at any postion or mid
        list.insertBykey(list, 9,2);list.insert(list, 1); // Q3
        list.insertAtstart(list, 2); //Q4
        list.insertBykey(list, 5,0); //Q5 at any postion or mid

        System.out.println(list.Display(list));
        list.swapAdj(list);
        System.out.println("swap every two adjacent number in "+list.Display(list));

    }
}
