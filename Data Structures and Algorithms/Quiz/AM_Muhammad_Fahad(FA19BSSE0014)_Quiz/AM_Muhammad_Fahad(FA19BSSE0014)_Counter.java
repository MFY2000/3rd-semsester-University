import java.util.Arrays;

class Counter {
    public int count(int key){
        int count = 0;
        for(int i = 1; i <= key; i++){
            for(int j = 1; j <= key; j++){
                for(int k = 1; k <= key; k++){
                    for(int m = 1; m <= key; m++)
                        if(i + j + k + m == key)
                            count++; 
                    
                    if(i + j + k == key)
                        count++;
                    }
                if(i+j == key)
                    count++;
            }
            if(i == key)
                    count++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.print((new counter()).count(4));
    }
}

// This code is contributed by Anant Agarwal.