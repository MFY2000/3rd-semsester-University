package Lab_Exam.Linkedlist;

import java.util.HashSet;

public class LinkedList {
    private Node head;

     int getLenght() {
        int i = 0;
        Node last = head;
        while (last.next != null) {
            i++;
            last = last.next;
        }
        return i;
    }
     boolean isEmpty() { return (head == null)?false:true; }

    // add the element in the linked list
    public void insert(int data) {
        Node new_node = new Node(data);
        new_node.next = null;

        if (!isEmpty())
            head = new_node;
        else {
            Node last = head;
            while (last.next != null)
                last = last.next;

            last.next = new_node;
        }
        }
        void insert(int data, int key) {
        int size = getLenght();
        Node new_node = new Node(data);
        Node prev = null;
        Node current = head;

        if(key == 0)
            insertAtstart(data);
        else if(key > size-1)
            insert(data);
        else{
            for(int i = 0; i < key; i++)
                current = (prev = current).next;

            new_node.next = current;
            prev.next = new_node;
        }
        }
        void insertAtstart(int data) {
        Node new_node = new Node(data);

        if (!(isEmpty()))
            head = new_node;
        else {
            new_node.next = head;
            head = new_node;
        }
        }
        void insertAll(int[] arr){
            for (int i = 0; i < arr.length; i++)
                insert(arr[i]);
        }

    // delete the element in the linked list
     void deleteByValue(int key){
        Node currNode = head,
                prev = null;

        if (currNode != null && currNode.Value == key) {
            head = currNode.next;
            System.out.println(key + " found and deleted");
            return;
        }

        while (currNode != null && currNode.Value != key)
            currNode = (prev = currNode).next;


        if (currNode != null) {
            prev.next = currNode.next;
            System.out.println(key + " found and deleted");
        }

        if (currNode == null)
            System.out.println(key + " not found");

    }
     void deleteBykey(int key){
        int size = getLenght();
        Node currNode = head,
                prev = null;

        if (size < key) {
            System.out.println(key + " not Exist");
            return;
        }

        if (key == 0){
            head = currNode.next;
            System.out.println((currNode.next).Value + " found and deleted");
            return;
        }

        for (int i=0; i<key; i++)
            currNode = (prev = currNode).next;

        prev.next = currNode.next;
        System.out.println(key + " found and deleted");

    }
     void delete(){
        deleteBykey(getLenght());
    }
     void deleteFront(){
        deleteBykey(0);
    }
     void deleteDuplicate(){
        HashSet<Integer> hs = new HashSet<>();

        Node current = head;
        Node prev = null;
        while (current != null) {
            if (hs.contains(current.Value)) prev.next = current.next;
            else {
                hs.add(current.Value);
                prev = current;
            }
            current = current.next;
        }
    }

    // update the element in the linked list
     void update( int index, int value){
        Node currNode = head;
        if (getLenght() < index) {
            System.out.println("Index not Exist! ");
            return;
        }

        for (int i = 0; i < index; i++)
            currNode = currNode.next;

        currNode.Value = value;
    }

     int get(int index){
        Node currNode = head;
        int value;
        if (getLenght() < index) {
            System.out.println("Index not Exist! ");
            return 0;
        }

        for (int i = 0; i < index; i++)
            currNode = currNode.next;

        value = currNode.Value;
        return value;
    }


    // search the element in the linked list
     Boolean Search(int key) {
        Node currNode = head;
        Boolean condition = false;

        if (currNode == null)
            return condition;


        while (currNode.Value != key)
            currNode = currNode.next;

        if (currNode != null) condition = true;
        else System.out.println(key + " not Exist(404 Error)");

        return condition;
    }
     int Search(int index,boolean bool) {
        Node currNode = head;
        int returnValue;

        if (currNode == null || getLenght()>index)
            return 0;

        for (int i = 0; i < index; i++)
            currNode = currNode.next;

        returnValue = currNode.Value;
        return returnValue;
    }

    //Sorting the Element in the
     void sortList() {
        Node current = head, index = null;
        int temp;

        if(current == null) {
            return;
        }
        else {
            while(current != null) {
                index = current.next;

                while(index != null) {
                    if(current.Value > index.Value) {
                        temp = current.Value;
                        current.Value = index.Value;
                        index.Value = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    //Merge Two linked list in the element
    LinkedList Merge(LinkedList list1,LinkedList list2){
        LinkedList list = new LinkedList();
        int l1 = getLenght(),l2 = getLenght();
        Node current = list1.head;

        for (int i = 0; i <= (l1+l2)+1; i++) {
            list.insert(current.Value);
            if (l1 != i) current = current.next;
            else current = list2.head;
        }
        return list;
    }

    //count the odd and even nodes
     int countOdd(){
        int count = 0;
        Node current = head;
        while (current.next != null){
            if (current.Value % 2 == 0)
                count++;
            current = current.next;
        }
        return count;
    }
     int countEven(){
        int count = 0;
        Node current = head;
        while (current.next != null){
            if (current.Value % 2 != 0)
                count++;
            current = current.next;
        }
        return count;
    }

    //swap the number
    void swap(Node n1,Node n2){
        int temp = n1.Value;
        n1.Value = n2.Value;
        n2.Value = temp;
    }

    public void swap(){
        swap(head.next,head.next.next,true);
    }
    public void swap(Node n1,Node n2,boolean t){
        Node temp = n1;
        n1 = n2;
        n2 = temp;
    }

     void swapAdj(){
        int count = 0;
        Node current = head;
        while (current.next != null) {
            swap(current,(current = current.next));
            current = current.next;
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
     String Displayreverse (){
        Node currNode = head;
        String display = "}";

        while (currNode != null) {
            display += currNode.Value + " ";
            currNode = currNode.next;
        }
        display += "{";

        display = "LinkedList reverse: " +(new StringBuilder(display)).reverse();
        return display;
    }

}
