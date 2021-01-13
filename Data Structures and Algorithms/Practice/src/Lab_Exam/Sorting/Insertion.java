package Lab_Exam.Sorting;

import java.util.Arrays;

public class Insertion {
    private int[] array_Search;
    private int key;
    private int lenght;
    private boolean flag;

    public Insertion(int[] array_search) {
        setArray_Search(array_search);
        setLenght();
        setFlag(true);

    }

    public int[] getArray_Search() { return array_Search; }
    public String getArray(){return Arrays.toString(getArray_Search());}
    public int getArray_index(int index) { return array_Search[index]; }
    public int getKey() { return key; }
    public int getLenght() { return lenght; }
    public boolean isFlag() { return flag; }

    public void setArray_Search(int[] array_Search) { this.array_Search = array_Search; }
    public void setArray_index(int index,int value) { array_Search[index] = value; }
    public void setKey(int key) { this.key = key; }
    public void setLenght() { this.lenght = (getArray_Search()).length; }
    public void setFlag(boolean flag) { this.flag = flag; }

    public void Sort(){
        for (int i = 1; i < getLenght(); ++i) {
            setKey(getArray_index(i));
            int j = i - 1;
            while (j >= 0 && getArray_index(j) > key) {
                setArray_index(j+1,getArray_index(j));
                j = j - 1;
            }
            setArray_index(j+1, key);
        }
    }

    public String toString(){
        Sort();
        return getArray();
    }
}
