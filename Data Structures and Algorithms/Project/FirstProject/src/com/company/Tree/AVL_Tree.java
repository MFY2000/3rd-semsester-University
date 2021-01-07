package com.company.Tree;

import java.util.Random;

public class AVL_Tree {
    public Node root;

    public final static class Node{
        int value;
        int balance;
        Node left, right;

        public Node(int item) {
            value = item;
            left = right = null;
        }
    }

    void Inorder(Node node) {
        if (node == null)
            return;

        Inorder(node.left);
        System.out.println(node.value);
        Inorder(node.right);

    }  // left,root,right
    void Postorder(Node node) {
        if (node == null)
            return;

        Postorder(node.left);
        Postorder(node.right);

        System.out.print(node.value + "("+getBalance(node)+") ->");
    }  // left, right, root
    void Preorder(Node node) {
        if (node == null)
            return;

        System.out.print(node.value+" , ");
        Preorder(node.left);
        Preorder(node.right);

    }   // root, left, right

    void updateHeight(Node n) {
        n.balance = height(n.left) - height(n.right);
    }
    int height(Node n) {
        return n == null ? -1 : n.balance;
    }
    int getBalance(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }
    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    Node rotateLeft(Node root) {
        Node newNode = root.right;
        Node temp = newNode.left;
        newNode.left = root;
        root.right = temp;

        // Update heights
        root.balance = max(height(root.left), height(root.right)) + 1;
        newNode.balance = max(height(newNode.left), height(newNode.right)) + 1;

        return newNode;
    }
    Node rotateRight(Node root) { // 5
        Node NewNode = root.left;   // 4.3.2.1
        Node temp = NewNode.right;  //null
        NewNode.right = root;       //
        root.left = temp;

        // Update heights
        root.balance = max(height(root.left), height(root.right)) + 1;
        NewNode.balance = max(height(NewNode.left), height(NewNode.right)) + 1;

        return NewNode;
    }

    Node rebalance(Node root){
        updateHeight(root);
        int balance = getBalance(root);

        if (balance > 1) {
            if (height(root.right.right) > height(root.right.left)) {
                root = rotateLeft(root);
                System.out.println("hi right");
            }
            else {
                root.right = rotateRight(root.right);
                root = rotateLeft(root);
            }
        } else if (balance < -1) {
            System.out.println("hi left");

            if (height(root.left.left) > height(root.left.right))
                root = rotateRight(root);
            else {
                root.left = rotateLeft(root.left);
                root = rotateRight(root);
            }
        }
        return root;
    }

    Node insert(Node node, int key) {
        if (node == null)
            return (new Node(key));

        if (key < node.value)
            node.left = insert(node.left, key);
        else if (key > node.value)
            node.right = insert(node.right, key);
        else
            return node;

        node.balance = 1 + max(height(node.left),
                height(node.right));

        int balance = getBalance(node);
        if (balance > 1) {
            if(key < node.left.value)
                return rotateRight(node);
            else if(key > node.left.value) {
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }
        }

        if (balance < -1){
            if(key > node.right.value)
                return rotateLeft(node);
            else if(key < node.right.value){
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
        }

        return node;
    }
    void insert(int value){
        root = insert(root,value);
    }

    Node minValueNode(Node node) {
        Node current = node;

        while (current.left != null)
            current = current.left;

        return current;
    }

    Node deleteNode(Node root, int key) {
        if (root == null)
            return root;

        if (key < root.value)
            root.left = deleteNode(root.left, key);

        else if (key > root.value)
            root.right = deleteNode(root.right, key);

        else {
            Node temp = null;
            if ((root.left == null) || (root.right == null)){
                temp = (temp == root.left)?root.right:root.left;

                if (temp == null) {
                    temp = root;
                    root = null;
                }
                else
                    root = temp;
            }
            else {
                temp = minValueNode(root.right);
                root.value = temp.value;
                root.right = deleteNode(root.right, temp.value);
            }
        }

        if (root == null)
            return root;

        root.balance = max(height(root.right), height(root.left)) + 1;
        int balance = getBalance(root);

        if (balance > 1) {
            if(key < root.left.value)
                return rotateRight(root);
            else if(key > root.left.value) {
                root.left = rotateLeft(root.left);
                return rotateRight(root);
            }
        }
        if (balance < -1){
            if(key > root.right.value)
                return rotateLeft(root);
            else if(key < root.right.value){
                root.right = rotateRight(root.right);
                return rotateLeft(root);
            }
        }

        return root;
    }
    void delete(int key){
        root = deleteNode(root,key);
    }
}



  class Test{
       public static void main(String[] args) {
           Random rand=new Random();

           AVL_Tree tree = new AVL_Tree();
           for (int i = 0; i < 12; i++)
               tree.insert(i);

//               tree.insert(rand.nextInt(i));

           System.out.print("\nPreorder: ");
           tree.Preorder(tree.root);

           tree.delete(5);
           tree.delete(9);
           tree.delete(2);

           System.out.print("\nPreorder: ");
           tree.Preorder(tree.root);

//              System.out.print("\nPostorder: ");
//              tree.Postorder(tree.root);
          }
  }
