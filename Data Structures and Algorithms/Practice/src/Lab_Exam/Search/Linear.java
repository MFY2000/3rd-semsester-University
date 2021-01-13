package Lab_Exam.Search;

import java.util.Arrays;

public class Linear {
    private int[] array_Search;
    private int key;
    private int index;
    private int lenght;
    private int count;
    private boolean flag;



    public Linear(int[] array_Search, int key){
        this.setArray_Search(array_Search);
        this.setKey(key);
        this.setCount(0);
        this.setIndex(-1);
        this.setLenght();
        this.setFlag(true);
    }

    public int[] getArray_Search() { return array_Search; }
    public String getArray(){return Arrays.toString(getArray_Search());}
    public int getArray_index(int index) { return array_Search[index]; }
    public int getKey() { return key; }
    public int getIndex() { return index; }
    public int getLenght() { return lenght; }
    public boolean isFlag() { return flag; }
    public int getCount() { return count; }

    public void setArray_Search(int[] array_Search) { this.array_Search = array_Search; }
    public void setKey(int key) { this.key = key; }
    public void setIndex(int index) { this.index = index; }
    public void setLenght() { this.lenght = (getArray_Search()).length; }
    public void setFlag(boolean flag) { this.flag = flag; }
    public void setCount(int count) { this.count = count; }

    private void Search(){
        for (int i = 0; i < getLenght(); i++) {
            if(getArray_index(i) == getKey()){
                setIndex(i);
                return;
            }
        }
        setFlag(false);
    }
    public void Occurence(){
        flag = false;
        for (int i = 0; i < getLenght(); i++) {
            if(getArray_index(i) == getKey()){
                flag = true;
                setIndex(i);
                setCount((getCount())+1);
            }
        }
        if(!flag)
            setFlag(false);
    }

    public String toString(){
        Search();
        return getArray()+" to Search: "+getKey()+(isFlag()?" ":"not ")+"Found: "+getIndex();
    }
    public String toString(boolean val){
        Occurence();
        String temp;
        temp = getArray()+" to Search: "+getKey();

        if(isFlag()){
          temp += " Found from: "+getIndex()+" No of Times Found:"+getCount();
        }else {
            temp += "not Found";
        }

        return temp;
    }
}
