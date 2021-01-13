package Lab_Exam.AVL_Tree;

public class Node {
    private Node leftChild = null, rightChild = null;
    private int cnt;
    private int height;
    private String value;


    Node(String Val){
        this.value = value;
        height = 1;
        cnt = 1;
    }

    public void setValue(String value) {
        // TODO Auto-generated method stub
        this.value = value;
    }
    public void setHeight(int height) { this.height = height; }
    public void setLeftChild(Node leftChild) { this.leftChild = leftChild; }
    public void setRightChild(Node rightChild) { this.rightChild = rightChild; }
    public void setCnt(int cnt) { this.cnt = cnt; }

    public Node getLeftChild() { return leftChild; }
    public int getHeight() { return height; }
    public Node getRightChild() { return rightChild; }
    public String getValue() { return value; }
    public int getCnt() { return cnt; }

    public int compareToo(String o) {
        return value.compareTo(o);
    }

    public boolean hasLeftChild() { return (leftChild == null)?false:true; }
    public boolean hasRightChild() { return (rightChild == null)?false:true; }
}