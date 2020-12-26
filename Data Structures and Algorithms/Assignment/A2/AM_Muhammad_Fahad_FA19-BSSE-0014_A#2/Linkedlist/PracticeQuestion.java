package com.company.Linkedlist;

public class PracticeQuestion {
    public static void main(String[] args) {
        Linkedlist list = new Linkedlist();
        System.out.println(list.Displayreverse()); //Q2

        list.insert(1); // Q3
        list.insertAtstart(2); //Q4
        list.insert(5,2); //Q5 at any postion or mid
        list.insert(9,2);
        list.insert(1); // Q3
        list.insertAtstart( 2); //Q4
        list.insert( 5,0); //Q5 at any postion or mid

        System.out.println(list.Display());

        list.update( 2,78); //Q5 at any postion or mid

        System.out.println(list.Display());

        list.deleteFront();
        list.deleteByValue(5);
        list.deleteBykey(9);
        list.delete();
        System.out.println(list.Display());

        list.insert( 5);
        list.insert( 9);
        System.out.println(list.Display());

        list.deleteDuplicate();
        System.out.println(list.Display());

    }
}
