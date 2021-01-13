package Lab_Exam.Tree;

public class Simple {
    Simple_Node root;

    Simple(){
        root = null;
    }

    void insert(int val, Simple_Node root){
        Simple_Node new_Node = new Simple_Node(val);
        root.child[root.count] = (new_Node);
        root.count++;
    }

    void insert(int val){
        insert(val,root);
    }

    void delete(int val){
        delete(val,root);
    }

    void delete(int val, Simple_Node root){
        for (int i = 0; i < root.count; i++) {
            Node save = root.child[i];
            Node[] Child = null;
            int count=-1;
            if(val != save.Value)
                Child[++count] = save;

        }


    }



}


class Simple_Node extends Node{
    public int count;
    Simple_Node(int data) {
        super(data);
        count = 0;
    }


}
