package com.company.Linkedlist;

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
        Queue() {
            this.front = this.rear = -1;
            this.items = new int[100];
        }


        String Get_Front(){
            return this.front+" = "+this.items[front];
        }
        String Get_Rear(){
            return this.rear+" = "+this.items[rear];
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
}
