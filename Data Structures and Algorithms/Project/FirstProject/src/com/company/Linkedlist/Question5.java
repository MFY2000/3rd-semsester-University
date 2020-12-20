package com.company.Linkedlist;

import java.util.*;

class Parentheses {


    void possibleOutcome(String exp) {
//         first index represent the start/Opening bracket
//         second index represent the end/closing bracket
//         third index represent the extra varaible
//         4th => possible outcome

        int outCome[] = {0, 0, 0, 0};
        String result = null;
        char c;
        for (int i = 0; i < exp.length(); i++) {
            c = exp.charAt(i);
            if (c == '(')
                outCome[0]++;
            else if (c == ')')
                outCome[1]++;
            else
                outCome[2]++;
        }

        outCome[3] = (outCome[0] != outCome[1] ? 3 : 0);
        System.out.println(Arrays.toString(outCome));
        if (outCome[3] != 0) {
            removeParenthesis(exp);
        }
        return;
    }

    void removeParenthesis(String str) {

    }
}

public class Question5 {
    public static void main(String[] args)
    {
        String expression = "()())()";
        Parentheses obj = new Parentheses();
        obj.possibleOutcome(expression);

//        expression = "()v)";
//        removeInvalidParenthesis(expression);
    }
}
