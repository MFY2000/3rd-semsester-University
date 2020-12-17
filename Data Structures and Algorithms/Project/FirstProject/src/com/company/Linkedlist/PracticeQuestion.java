package com.company.Linkedlist;

public class PracticeQuestion {
    public static void main(String[] args) {
        Linkedlist list = new Linkedlist();
        System.out.println(list.Displayreverse(list)); //Q2

        list.insert(list, 1); // Q3
        list.insertAtstart(list, 2); //Q4
        list.insertBykey(list, 5,2); //Q5 at any postion or mid
        list.insertBykey(list, 9,2);list.insert(list, 1); // Q3
        list.insertAtstart(list, 2); //Q4
        list.insertBykey(list, 5,0); //Q5 at any postion or mid

        System.out.println(list.Display(list));

        list.update(list, 2,78); //Q5 at any postion or mid

        System.out.println(list.Display(list));

        list.deleteFront(list);
        list.deleteByValue(list,5);
        list.deleteBykey(list,9);
        list.delete(list);
        System.out.println(list.Display(list));

        list.insert(list, 5);
        list.insert(list, 9);
        System.out.println(list.Display(list));

        list.deleteDuplicate(list);
        System.out.println(list.Display(list));

    }
}
