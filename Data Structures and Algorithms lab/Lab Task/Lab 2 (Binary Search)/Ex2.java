package com.company;

import java.util.Arrays;

public class Ex2 {
    public static void main(String[] args) {

        System.out.println("2) Implement Binary Search to find the number of occurrences of the given key.");

        int arr[] = {3,5,5,9,9,9,10,11};

        int LP = 0,
            RP = arr.length-1,
            mid,
            key = 9,
            count = 0,
            temp;

        boolean checkBefore=false,
                check = false,
                flag = false;

        System.out.println("The array is: "+ Arrays.toString(arr));
        System.out.println("The key is: "+key);

        while (LP<=RP){
            mid = (LP+RP)/2;
            if(key == arr[mid]){
                temp = mid;
                do {
                    if (!checkBefore && temp != 0) { //first we will go toward the back
                        temp--; // for example the mid index is 3 and value is 9 so we will check the next previous index
                        check=true; // means the index change and we have to check
                    }
                    else if(checkBefore && temp != (arr.length-1)){ //if we will not found it on previous index so known we have check next index
                        temp++;    // for example the mid index is 3 and value is 9 so we will check the next index
                        check=true;// means the index change and we have to check
                    }
                    else
                        check = false;  // when both side are check


                    if(check && arr[temp] == key){ // it will work on both side forward and backword indexs
                        count++; // mean the Occurrences found
                    }
                    else if(!checkBefore && check) { // if the same value not found so we have to move forword
                        checkBefore = !checkBefore;  // so we have to move forword(on the next index from mid)
                        temp = mid; // again set mid point s you we will move forword

                    }
                }while(check);
                count++;
                break;
            }

            if(arr[mid]<key){
                LP = mid+1;
            }
            else if(arr[mid]>key){
                RP = mid-1;
            }
        }

        if (flag){
            System.out.println("The key not found in the array");
        }
        else {
            System.out.println("The Occurrences of the given key: " + key + " is: " + count + " times");
        }

    }
}
