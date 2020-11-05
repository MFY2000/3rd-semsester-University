package com.company.Sorting;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int array[] = {5,6,1,1,8,9,3,5};

        Sorting ob = new Sorting();

        ob.SelectionSorting(array);
        ob.InsertionSorting(array);

    }
}
class Sorting{

    void SelectionSorting(int arr[]){
        int length = arr.length,
            swap,
            countloop = 0;
        System.out.println("----------------------------------------- Selection Sorting ----------------------------------------- ");
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < (length-1); i++) {
            int minIndex = i;
            for (int j = i+1; j < length; j++) {
                System.out.println("j = "+j+",minIndex = "+minIndex+",minValue = "+arr[minIndex]+",Check("+arr[j]+"<"+arr[minIndex]+") => "+(arr[j] < arr[minIndex]));
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
                countloop++;
            }
            swap = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = swap;
            System.out.println("----------------------------------------- i = "+i+" Complete -----------------------------------------");
            System.out.println(Arrays.toString(arr));

        }

        System.out.println("Number of time value inner loop works: "+countloop);
    }

    void InsertionSorting(int arr[]) {
        int length = arr.length,
        countloop = 0;
        System.out.println("----------------------------------------- Selection Sorting ----------------------------------------- ");
        System.out.println(Arrays.toString(arr));

        for (int i = 1; i < (length); ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                System.out.println("j = "+j+",key = "+key+",Check("+arr[j]+"<"+key+") => "+(j >= 0 && arr[j] > key));
                arr[j + 1] = arr[j];
                j = j - 1;
                countloop++;
            }
            arr[j + 1] = key;
            System.out.println(Arrays.toString(arr));
            System.out.println("----------------------------------------- i = " + i + " Complete -----------------------------------------");

        }
        System.out.println("Number of time value inner loop works: "+countloop);
    }


    void BubbleSort(int arr[]){
        int length = arr.length;
        int swap;
        for (int i = 0; i < (length-1); i++) {
            System.out.println("------------------------- i = "+i+"-----------------------------------------");
            for (int j = 0; j < (length-i)-1; j++) {
                System.out.print(" j = "+j+" Check("+arr[j]+">"+arr[j+1]+") "+"Swap = "+(arr[j] > arr[j+1]));
                if (arr[j] > arr[j+1]) {
                    swap = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = swap;
                }
                System.out.println(" "+Arrays.toString(arr));
            }
        }
    }

    void MergeSorting(int arr[],int left,int right){
        System.out.print(" left = "+left+" right = "+right);

        if(left<right){
            int mid = (left+right)/2;
            MergeSorting(arr,left,mid);
            System.out.print("\n | ");
            MergeSorting(arr,mid+1,right);

//            Merge(arr,left,mid,right);
        }

    }

    private void Merge(int arr[], int l, int m, int r){
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

}


