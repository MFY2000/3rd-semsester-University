package Lab_Exam.Linkedlist;

public class Double_linkList {
    Double_node head, tail = null;

    boolean isEmpty() { return (head == null)?false:true; }


    public void insert(int data) {
        Double_node new_node = new Double_node(data);
        new_node.next = null;

        if (!isEmpty()) {
            tail = head = new_node;
            tail.next = head.prev = null;
        }
        else {
            tail.next = new_node;
            new_node.prev = tail;

            tail = new_node;
            tail.next = null;
        }
    }

    //Display methods
    public String toString(){
        Node currNode = head;
        String display = "LinkedList: {";

        while (currNode != null) {
            display += currNode.Value + ", ";
            currNode = currNode.next;
        }
        display += "\b\b};";
        return display;
    }


    public void display() {
    }
}

class Double_node extends Node{
    Node prev;

    Double_node(int data) {
        super(data);
        next = null;
    }
}