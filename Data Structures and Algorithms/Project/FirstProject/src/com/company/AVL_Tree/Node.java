package com.company.AVL_Tree;

import com.company.Interface.INode;

public class Node<T> implements INode<T> {
    private Node<T> leftChild = null, rightChild = null;
    private int cnt;
    private int height;
    private T value;

    public Node(T value) {
        this.value = value;
        height = 1;
        cnt = 1;
    }


    public void setValue(T value) {
        // TODO Auto-generated method stub
        this.value = value;
    }
    public void setHeight(int height) { this.height = height; }
    public void setLeftChild(Node<T> leftChild) { this.leftChild = leftChild; }
    public void setRightChild(Node<T> rightChild) { this.rightChild = rightChild; }
    public void setCnt(int cnt) { this.cnt = cnt; }

    public INode<T> getLeftChild() {
        // TODO Auto-generated method stub
        return leftChild;
    }
    public int getHeight() { return height; }
    public INode<T> getRightChild() {
        // TODO Auto-generated method stub
        return rightChild;
    }
    public T getValue() {
        // TODO Auto-generated method stub
        return value;
    }
    public int getCnt() { return cnt; }

    public int compareTo(T o) {
        // TODO Auto-generated method stub
        @SuppressWarnings("unchecked")
        Comparable<T> comparable = ((Comparable<T>) value);
        return comparable.compareTo(o);
    }

    public boolean hasLeftChild() {
        if (leftChild == null) {
            return false;
        }
        return true;
    }
    public boolean hasRightChild() {
        if (rightChild == null) {
            return false;
        }
        return true;
    }
}
