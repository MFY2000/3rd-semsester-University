package Lab_Exam.Sorting;

import java.util.Arrays;

public class Merge {
    private int[] array_Search;
    private int lenght;

    public Merge(int[] array_search) {
        setArray_Search(array_search);
        setLenght();
    }

    public int[] getArray_Search() { return array_Search; }
    public String getArray(){return Arrays.toString(getArray_Search());}

    public void setArray_Search(int[] array_Search) { this.array_Search = array_Search; }
    public void setLenght() { this.lenght = (getArray_Search()).length; }

    private void merge(int A[] , int start, int mid, int end) {
        int low = start, middle = mid+1, count=0;
        int temp[] = new int[(end-start)+1];

        while (low <= mid && middle <= end){
            if (A[low] < A[middle])
                temp[count] = A[low++];
            else
                temp[count] = A[middle++];
            count++;
        }

        while(low<=mid){
            temp[count] = A[low];
            count++;
            low++;
        }

        while(middle<=end){
            temp[count] = A[middle];
            count++;
            middle++;
        }

        for (int i = 0; i < count; i++,start++)
            A[start] = temp[i];

    }
    private void Sort(int arr[],int low,int high){
        int mid;
        if(low < high){
            mid=(low+high)/2;

            Sort(arr,low,mid);
            Sort(arr,mid+1,high);

            merge(arr,low,mid,high);
        }
    }

    @Override
    public String toString() {
        Sort(getArray_Search(),0,lenght-1);
        return getArray();
    }
}
