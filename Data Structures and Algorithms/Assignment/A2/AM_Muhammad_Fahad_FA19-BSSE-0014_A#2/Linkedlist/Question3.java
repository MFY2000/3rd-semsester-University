package com.company.Linkedlist;

import java.io.IOException;
import java.util.Scanner;

//Q3. Do as directed
//a) Create two separate singly linked list based on your input
//b) Sort them individually
//c) Now, merge them in a new linked list
//d) Display finally sorted list
//e) delete any specific user defined value from the list
//f) search any specific user defined value from list
//g) count the odd and even nodes (nodes containing odd/even values)
//h) exit from menu
public class Question3 {
    public static void main(String[] args) throws IOException {
        int key;
        Linkedlist list = null,list2 = null, Mergelist = null;
        Scanner scan = new Scanner(System.in);

        while (true){
            System.out.println("//0) Create two separate singly linked list based on your input\n" +
                                "//1) Sort them individually\n" +
                                "//2) Now, merge them in a new linked list\n" +
                                "//3) Display finally sorted list\n" +
                                "//4) delete any specific user defined value from the list\n" +
                                "//5) search any specific user defined value from list\n" +
                                "//6) count the odd and even nodes (nodes containing odd/even values)\n" +
                                "//7) exit from menu\n Now Enter: ");
            key = scan.nextInt();
            if (key == 0||key == 7){
                switch (key){
                    case 0:
                        list = new Linkedlist();
                        list2 = new Linkedlist();
                        System.out.print("Enter the length of the Linkedlist A: ");
                        int in = scan.nextInt();
                        int temp = 0;
                        for (int i = 0; i < in; i++) {
                            System.out.print(i+" = ");
                            temp = scan.nextInt();
                            list.insert(temp);
                        }

                        System.out.print("Enter the length of the Linkedlist B: ");
                        in = scan.nextInt();
                        for (int i = 0; i < in; i++) {
                            System.out.print(i+" = ");
                            temp = scan.nextInt();
                            list2.insert(temp);
                        }

                    case 1:
                        list.sortList();
                        list2.sortList();

                        System.out.println("A) "+list.Display());
                        System.out.println("B) "+list2.Display());

                    case 2:
                        Mergelist = Linkedlist.Merge(list,list2);
                        System.out.println("C) Merge "+Mergelist.Display());
                    case 3:
                        Mergelist.sortList();
                        System.out.println("C) Merge "+Mergelist.Display());
                    case 4:
                        System.out.print("Enter the value to delete from Merge Linkedlist: ");
                        in = scan.nextInt();
                        Mergelist.deleteByValue(in);
                        System.out.println(Mergelist.Display());
                    case 5:
                        System.out.print("Enter the value to Search from Merge Linkedlist: ");
                        in = scan.nextInt();
                        System.out.println(in+(Mergelist.Search(in) ? " ":" not")+" found in the Merge Linkedlist: ");
                    case 6:
                        System.out.println("Odd in the Merge Linkedlist: "+ Mergelist.countOdd());
                        System.out.println("Even in the Merge Linkedlist: "+ Mergelist.countEven());
                    case 7:
                        System.out.println("Exiting from the Menu \uD83D\uDE00");
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + key);
                }
            }
            else System.out.println("Again Enter (Can't go directly to any case)");
        }

    }
}
