package Lab_Exam.Sorting;

import java.util.Arrays;

public class Quick {
    private int[] array_Search;
    private int lenght;

    public Quick(int[] array_search) {
        setArray_Search(array_search);
        setLenght();
    }

    public int[] getArray_Search() { return array_Search; }
    public String getArray(){return Arrays.toString(getArray_Search());}
    public int getArray_index(int index) { return array_Search[index]; }

    public void setArray_Search(int[] array_Search) { this.array_Search = array_Search; }
    public void setArray_index(int index,int value) { array_Search[index] = value; }
    public void setLenght() { this.lenght = (getArray_Search()).length; }

    void Sort(int low, int high){
        if (low < high){
            int pi = partition(low, high);

            Sort(low, pi-1);
            Sort(pi+1, high);
        }
    }
    int partition(int low, int high){
        int pivot = getArray_index(high);
        int i = (low-1);
        for (int j=low; j<=high; j++)
            if (getArray_index(j) < pivot)
                i += swap(i+1,j);

        return (i+swap(i+1,high));
    }

    public int swap(int i, int j) {
        int temp = getArray_index(i);
        setArray_index(i,getArray_index(j));
        setArray_index(j, temp);
        return 1;
    }

    @Override
    public String toString() {
        Sort(0,lenght-1);
        return getArray();
    }
}
