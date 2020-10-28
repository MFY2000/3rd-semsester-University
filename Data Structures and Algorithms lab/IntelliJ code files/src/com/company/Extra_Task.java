package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Extra_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        int ContestProblem =  Integer.parseInt(scan.readLine());
        int Bilal,Ali,Umar,implementedProbems = 0;
        String temp[];

        for (int i = 0; i < ContestProblem; i++) {

            temp = scan.readLine().split(" ");

            Ali = Integer.parseInt(temp[0]);
            System.out.print("\b");
            Bilal = Integer.parseInt(temp[1]);
            System.out.print("\b");
            Umar = Integer.parseInt(temp[2]);

            if((Ali+Bilal+Umar) >=2 ){
                implementedProbems++;
            }
        }

        System.out.println(implementedProbems);

    }
}
