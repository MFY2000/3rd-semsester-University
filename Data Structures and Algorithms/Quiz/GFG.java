package com.company;

import java.util.Arrays;

class GFG {
    public static int count(int key){
        int count = 0;
        for(int i = 1; i <= 4; i++){
            if(i == key)
                count++;

            for(int j = 1; j <= 4;j++){
                if(i+j == key)
                    count++;

                for(int k = 1; k <= 4; k++){
                    if(i + j + k == key)
                        count++;

                    for(int m = 1; m <= 4; m++){
                        if(i + j + k + m == key)
                            count++;

                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.print(count(4));
    }
}

// This code is contributed by Anant Agarwal.