package com.company.AVL_Tree;


public class AVLTreeOperations<T> {

    int getHeight(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return node.getHeight();
    }
    int getMax(int first, int second) {
        return (first > second) ? first : second;
    }
    int getBalance(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return (getHeight((Node<T>) node.getLeftChild()) - getHeight((Node<T>) node.getRightChild()));
    }

    Node<T> rightRotate(Node<T> y) {
        Node<T> x = (Node<T>) y.getLeftChild();
        Node<T> t2 = (Node<T>) x.getRightChild();

        x.setRightChild(y);
        y.setLeftChild(t2);

        y.setHeight(1 + getMax(getHeight((Node<T>) y.getLeftChild()), getHeight((Node<T>) y.getRightChild())));
        x.setHeight(1 + getMax(getHeight((Node<T>) x.getLeftChild()), getHeight((Node<T>) x.getRightChild())));

        return x;
    }
    Node<T> leftRotate(Node<T> y) {
        Node<T> x = (Node<T>) y.getRightChild();
        Node<T> t2 = (Node<T>) x.getLeftChild();

        x.setLeftChild(y);
        y.setRightChild(t2);

        y.setHeight(1 + getMax(getHeight((Node<T>) y.getLeftChild()), getHeight((Node<T>) y.getRightChild())));
        x.setHeight(1 + getMax(getHeight((Node<T>) x.getLeftChild()), getHeight((Node<T>) x.getRightChild())));

        return x;
    }

}
