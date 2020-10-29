package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BubbleSorting3 {
    public static void main(String[] args) throws IOException {
        int length,size,i;
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("3) In Word Document");
        String temp[];
        Scanner s = new Scanner(System.in);
        temp = scan.readLine().split(" ");
        length = Integer.parseInt(temp[0]);
        size = Integer.parseInt(temp[1]);

        int UserInput[][] = new int[length][size];

        for (i = 0; i < length; i++) {

        }

    }
}



/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader

*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N =Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        ArrayList<Fan> arr = new ArrayList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            Fan fan = new Fan(st.nextToken(), Integer.parseInt(st.nextToken()));
            arr.add(fan);
        }
        Collections.sort(arr, new SortByPointAndName());
        // for(Fan fan: arr)
        //     System.out.println(fan.name+" "+fan.point);
        for(int i=0;i<T;i++)
            System.out.println(arr.get(i).name);
    }
    static class SortByPointAndName implements Comparator<Fan>
    {
        public int compare(Fan a, Fan b)
        {
            if(a.point==b.point){
                return a.name.compareTo(b.name);
            }
            return b.point-a.point;
        }
    }
    static class Fan{
        String name;
        int point;
        Fan(String name, int point){
            this.name = name;
            this.point = point;
        }
    }
}
