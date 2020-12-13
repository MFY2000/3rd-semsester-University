package com.company;

public class Quicksort {
    static boolean print = true;
    static int pivot;
    public static void main(String[] args) {
        String temp = "SORTINGEXAMPLE";

        int[] arr = ConvertIntemp(temp);
        int low = 0;
        int high = arr.length-1;

        System.out.println("---------- Quick Sort ----------");
        System.out.println("Input: "+ temp);

        sort(arr,low,high);


        System.out.println("Sorted: "+ConvertInString(arr));
    }

    static int[] ConvertIntemp(String temp){
        int[] arr = new int[temp.length()];

        for (int i = 0; i < temp.length(); i++) {
           arr[i] = Integer.parseInt(String.valueOf((int) temp.charAt(i)));
        }

        return arr;
    }
    static String ConvertInString(int[] temp){
        String arr = "";

        for (int i = 0; i < temp.length; i++) {
            arr += String.valueOf((char) temp[i]);
        }

        return arr;
    }



    static void sort(int arr[], int low, int high){
        if (low < high){
            int pi = partition(arr, low, high);
            if(true){
                if(arr.length/2 <= low){
                    System.out.print("Recurse right: ");
                }else {
                    System.out.print("Recurse Left: ");
                }
                    System.out.print(ConvertInString(arr)+"\n");

            }

            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }

    static int partition(int arr[], int low, int high){
        pivot = arr[high];
        int i = (low-1); // index of smaller element

        if(print){
            print = false;
            System.out.println("Pivot: "+((char) pivot)+"  "+ConvertInString(arr));
        }

        for (int j=low; j<high; j++)
            if (arr[j] < pivot)
                i += swap(arr,i+1,j);


        return (i+swap(arr,i+1,high));
    }

    public static int swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return 1;
    }
}
