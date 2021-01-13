package Lab_Exam.Tree;

public class Simple {
    Simple_Node root;

    Simple(){
        root = null;
    }

    void insert(int val, Simple_Node root){
        Simple_Node new_Node = new Simple_Node(val);
        root.child[root.count] = (new_Node);
    }

    void insert(int val){
        
    }
}


class Simple_Node extends Node{
    public int count;
    Simple_Node(int data) {
        super(data);
        count = 0;
    }


}
