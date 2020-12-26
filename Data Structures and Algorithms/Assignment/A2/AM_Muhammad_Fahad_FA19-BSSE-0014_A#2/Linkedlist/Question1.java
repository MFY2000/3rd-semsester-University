package com.company.Linkedlist;

import java.util.LinkedList;
import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
//        (new A()).Working();

        LinkedList<String> symbol = new LinkedList<>();
        Linkedlist Value = new Linkedlist();

        symbol.add("GOOG");
        Value.insert(50);

        symbol.add("BING");
        Value.insert(12);

        symbol.add("Yahoo");
        Value.insert(20);

        symbol.add("GAOG");
        Value.insert(80);

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("1 > to display Stock");
            System.out.println("2 > Search Stock");
            System.out.println("0 > Exit");
            System.out.println("Enter: ");
            int key = scan.nextInt();
            switch (key) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("The name of the stock" + symbol.toString());
                    System.out.println("The Price of the stock" + Value.Display());
                case 2:
                    for (int i = 0; i < symbol.size(); i++) {
                        System.out.println(i + " > " + symbol.get(i) + " = " + Value.get(i));
                    }
                    System.out.print("Enter: ");
                    int key2 = scan.nextInt();
                    System.out.print("Enter (1 to buy and sell order)");

                    if (scan.nextInt() == 1) {
                        (new B(Value.get(key2), symbol.get(key2))).Working();
                    }
                    break;
            }
        }
    }
}

class B{
    int Value;
    String symbol;

    B(int value,String name){
        Value = value;
        symbol = name;
    }

    void Working(){
        Scanner scan =new Scanner(System.in);
        Boolean conBoolean = true;
        int amount;
        while (conBoolean){
            System.out.println("1 => Buy Order");
            System.out.println("2 => Sell Order");
            System.out.println("0 => Exit");
            int key = scan.nextInt();
            switch (key){
                case 0:
                    conBoolean = false;
                    break;
                case 1:
                    System.out.print("Enter Amount: ");
                    amount = scan.nextInt();
                    if(Value > amount)
                        System.out.println("You can buy it");
                    else
                        System.out.println("Not possible !!!");
                    break;
                case 2:
                    System.out.print("Enter Amount: ");
                    amount = scan.nextInt();
                    if(Value < amount)
                        System.out.println("You can Sell it");
                    else
                        System.out.println("Not possible !!!");
                    break;
            }

        }
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