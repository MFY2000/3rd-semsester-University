package com.company.Linkedlist;

import java.util.LinkedList;
import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        (new A()).Working();


    }
}
class B{
    private static Linkedlist Value;
    private static LinkedList<String> symbol;

    B(){
        Value = new Linkedlist();
        symbol = new LinkedList<String>();
    }

    
}

class A{
    void Working(){
        int limit = ValueInput("Enter the value to which under-valued or over-valued stocks : ");
        Queue data = new Queue();
        while (true){
            int togo = ValueInput("\n1 to display stock \n2 to enter new value\nEnter: ");
            switch (togo){
                case 2:
                    int tenmp = ValueInput("Enter the value: ");
                    if(limit < tenmp){
                        data = new Queue();
                        data.enQueue(limit = tenmp);
                        System.out.println("Stock is update");
                    }
                    else if(limit > tenmp)
                        data.enQueue(tenmp);
                    else
                        System.out.println("Equal..................");

                case 1:
                    System.out.println(data.display());
            }
        }
    }

    static int ValueInput(String e){
        Scanner scan = new Scanner(System.in);
        System.out.print(e);
        return scan.nextInt();
    }
}