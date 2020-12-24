package com.company.Linkedlist;

public class Question4 {
    public static void main(String[] args) {
        Linkedlist list = new Linkedlist();

        list.insert(1); // Q3
        list.insertAtstart( 2); //Q4
        list.insert( 5,2); //Q5 at any postion or mid
        list.insert(9,2);
        list.insert(1); // Q3
        list.insertAtstart( 2); //Q4
        list.insert(5,0); //Q5 at any postion or mid

        System.out.println(list.Display());
        list.swapAdj();
        System.out.println("swap every two adjacent number in "+list.Display());

    }
}
