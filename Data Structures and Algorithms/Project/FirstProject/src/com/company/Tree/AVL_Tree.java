package com.company.Tree;

public class AVL_Tree {
    public Node root;

    static class Node{
        int value;
        int balance;
        Node left, right;


        public Node(int item) {
            value = item;
            left = right = null;
        }
    }
    void updateHeight(Node n) {
        n.balance = 1 + Math.max(height(n.left), height(n.right));
    }

    int height(Node n) {
        return n == null ? -1 : n.balance;
    }

    int getBalance(Node n) {
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }
    Node rotateLeft(Node root) {
        Node newNode = root.right;
        Node temp = newNode.left;
        newNode.left = root;
        root.right = temp;
        return newNode;
    }
    void Inorder(Node node,String value) {
        if (node == null)
            return;

        Inorder(node.left,value+" Left");
        System.out.print(node.value + "("+getBalance(node)+" "+value+") ->");
        Inorder(node.right,value+" right");
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

        System.out.print(node.value + "("+getBalance(node)+") ->");
        Preorder(node.left);
        Preorder(node.right);

    }   // root, left, right

    Node rotateRight(Node root) { // 5
        Node NewNode = root.left;   // 4.3.2.1
        Node temp = NewNode.right;  //null
        NewNode.right = root;       //
        root.left = temp;
        updateHeight(root);
        updateHeight(NewNode);
        return NewNode;
    }

    public static void main(String[] args) {
        AVL_Tree obj = new AVL_Tree();
        obj.root = new Node(5);
        obj.root.left = new Node(4);
        obj.root.left.left = new Node(3);
        obj.root.left.left.left = new Node(2);
        obj.root.left.left.left.left = new Node(1);
        obj.root.left.left = obj.rotateRight(obj.root.left.left);

        System.out.print("Inorder: ");
        obj.Inorder(obj.root,"root");

        System.out.print("\nPreorder: ");
        obj.Preorder(obj.root);

        System.out.print("\nPostorder: ");
        obj.Postorder(obj.root);
    }
}
