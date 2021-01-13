package _AVLTree;

import _AVLTreeIf.INode;

public class Node<T> implements INode<T> {

    /**
     * each node has left and right child. initially they are null.
     */
    private Node<T> leftChild = null, rightChild = null;

    /**
     * number of similar nodes.
     */
    private int cnt;

    /**
     * height is number of nodes in path including itself.
     */
    private int height;

    /**
     * the element we use AVL for.
     */
    private T value;

    /**
     * @param value
     *            of this node.
     */
    public Node(T value) {
        this.value = value;
        height = 1;
        cnt = 1;
    }

    /**
     * @param height
     *            is the new height.
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return current height.
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param leftChild
     *            is the new left child.
     */
    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    /**
     * @return true if has left child.
     */
    public boolean hasLeftChild() {
        if (leftChild == null) {
            return false;
        }
        return true;
    }

    /**
     * @return left child. it may be null.
     */
    @Override
    public INode<T> getLeftChild() {
        // TODO Auto-generated method stub
        return leftChild;
    }

    /**
     * @param rightChild
     *            is the new right child.
     */
    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    /**
     * @return true if has right child.
     */
    public boolean hasRightChild() {
        if (rightChild == null) {
            return false;
        }
        return true;
    }

    /**
     * @return right child. it may be null.
     */
    @Override
    public INode<T> getRightChild() {
        // TODO Auto-generated method stub
        return rightChild;
    }

    /**
     * a new value in this node.
     */
    @Override
    public void setValue(T value) {
        // TODO Auto-generated method stub
        this.value = value;
    }

    /**
     * return the current value.
     */
    @Override
    public T getValue() {
        // TODO Auto-generated method stub
        return value;
    }

    /**
     * compare a value o with the value of this node.
     */
    @Override
    public int compareTo(T o) {
        // TODO Auto-generated method stub
        @SuppressWarnings("unchecked")
        Comparable<T> comparable = ((Comparable<T>) value);
        return comparable.compareTo(o);
    }

    /**
     * for Duplications.
     * 
     * @return number of this nodes.
     */
    public int getCnt() {
        return cnt;
    }

    /**
     * for Duplications.
     * 
     * @param cnt
     *            to set the new number of this node.
     */
    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

}
