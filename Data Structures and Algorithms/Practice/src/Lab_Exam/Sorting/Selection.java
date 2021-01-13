package Lab_Exam.Sorting;

import java.util.Arrays;

public class Selection {
    private int[] array_Search;
    private int key;
    private int lenght;
    private boolean flag;

    public Selection(int[] array_search) {
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
    for (int i = 0; i < getLenght()-1; i++) {
        int minIndex = i;
        for (int j = i+1; j < getLenght(); j++)
            if (getArray_index(j) < getArray_index(minIndex))
                minIndex = j;

        Swap(minIndex,i);
        }
    }
    public void Swap(int j,int i){
        int swap = getArray_index(j);
        setArray_index(j,getArray_index(i));
        setArray_index(i,swap);
    }

    public String toString(){
        Sort();
        return getArray();
    }
}
