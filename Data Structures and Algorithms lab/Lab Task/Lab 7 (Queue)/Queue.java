package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Queue {
    public int SIZE,front, rear;
    public int[] items;

    Queue(int Size) {
        this.SIZE = Size;
        this.front = this.rear = -1;
        this.items = new int[SIZE];
    }

    String Get_Front(){
        return this.front+" = "+this.items[front];
    }

    String Get_Rear(){
        return  this.rear+" = "+this.items[rear];
    }

    boolean isFull() {
        if (front == 0 && rear == SIZE - 1) {
            return true;
        }
        return false;
    }

    // check if the queue is empty
    boolean isEmpty() {
        if (front == -1)
            return true;
        else
            return false;
    }

    // insert elements to the queue
    void enQueue(int element) {
        // if queue is full
        if (isFull()) {
            System.out.println("Queue Is full");
        }
        else {
            if (front == -1) {
                front = 0;
            }

            rear++;
            items[rear] = element;
        }
    }

    // delete element from the queue
    int deQueue() {
        int element;

        if (isEmpty()) {
            System.out.println("Queue Is Empty");
            return (-1);
        }
        else {
            element = items[front];

            if (front >= rear) {
                front = -1;
                rear = -1;
                items = new int[this.SIZE];
            }
            else {
                front++;
                items = Arrays.copyOfRange(items, 1, rear+1);
                items = Arrays.copyOf(items, this.SIZE);
                rear--;
            }

            return (element);
        }
    }


    String display() {
        String temp = "{";
        if (isEmpty()){
            temp += " }";
            return temp;
        }

        for (int i = 0; i <= rear; i++) {
            temp += items[i]+",";
        }
        temp += "\b}";
        return temp;
    }

    public static void main(String[] args) {
        System.out.println("Q1) Create your own queue class with following methods: (Enqueue, Dequeue, Get_Front, Get_Rear");
        Queue q = new Queue(8);

        for(int i = 1; i < 9; i ++) {
            q.enQueue(i);
        }

        System.out.println("Queue"+q.display());
        System.out.println("Dequeue: "+q.deQueue());
        q.enQueue(9);
        System.out.println("Enqueue:"+q.display());
        System.out.println("Get_Front: "+q.Get_Front()+", Get_Rear: "+q.Get_Rear());
    }
}

class Queue2 extends Queue{

    Scanner scan = new Scanner(System.in);
    Queue2(int size){
        super(size);
    }

    int Delete(int Element){
        boolean flag = false;
        if (isEmpty()){
            System.out.println("Queue Is Empty");
            return (-1);
        }
        int length = rear-front;
        for (int i = length; i > 0; i--) {
            if(items[i] == Element){
                items[i] = items[i-1];
                items[i-1] = Element;
            }
        }

        if(flag){
            System.out.print("Number not found in the Queue (Error: ");
            return (-1);
        }

        return this.deQueue();
    }

    void Input(){
        System.out.print("Enter the Complete Array(separate with ,): ");
        String input[] = (scan.next()).split(",");

        for (int i = 0; i < input.length; i++)
            this.enQueue(Integer.parseInt(input[i]));
    }

    public static void main(String[] args) {
        Queue2 obj = new Queue2(8);
        obj.Input();
        System.out.println(obj.display());
        System.out.print("Enter the number to delete from the queue: ");
        int element = obj.scan.nextInt();
        System.out.println("Delete: "+obj.Delete(element));
        System.out.println(obj.display());

    }
}
