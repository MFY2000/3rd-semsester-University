package com.company.Linkedlist;

import java.util.*;

class Parentheses {
String Result = "";
int openLeft;
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

        outCome[3] = (outCome[0] != outCome[1] ? 1 : 0);
        if (outCome[3] != 0) {
//            removeParenthesis(exp,"");
            CompleteParenthesis(exp,"");
        }
        return;
    }

    String reverse(String exp){
        String temp = "";
        for (int i = exp.length()-1; i >=0; i--) {
            temp += exp.charAt(i) == '(' ? ')':exp.charAt(i) == ')'?'(':exp.charAt(i);
        }

        return temp;
    }

    void removeParenthesis(String left,String right) {
        System.out.println(left+"   "+right);

        if(left.length()==0){
            if(openLeft != 0){
                openLeft = 0;
                removeParenthesis(reverse(right), "");
                right = reverse(this.Result);
            }
            if (openLeft == 0){
                this.Result = right;
                return;
            }
        }

        if(left.charAt(0) == '('){
            openLeft++;
            removeParenthesis(left.substring(1),right+"(");
        }
        else if(left.charAt(0) == ')'){
            if(right.length() != 0 && right.charAt(right.length()-1) == '(' || openLeft != 0){
                openLeft--;
                removeParenthesis(left.substring(1),right+")");
            }
            else removeParenthesis(left.substring(1),right);
        }
        else removeParenthesis(left.substring(1),right+left.charAt(0));
    }
    void CompleteParenthesis(String left,String right){
        if(left.length() == 0){
            this.Result += right;
            return;
        }

        if(left.charAt(0) == '('){
            openLeft++;
            CompleteParenthesis(left.substring(1),right+"(");
        }
        else if(left.charAt(0) == ')'){
            if(right.length() != 0 && right.charAt(right.length()-1) == '(' || openLeft != 0){
                openLeft--;
                CompleteParenthesis(left.substring(1),right+")");
            }
            else{

                CompleteParenthesis(left.substring(1),right+')');
            }
        }
        else CompleteParenthesis(left.substring(1),right+left.charAt(0));
    }

}

public class Question5 {
    public static void main(String[] args)
    {
        String expression = "()())()";
        Parentheses obj = new Parentheses();
        obj.possibleOutcome(expression);
        System.out.println(obj.Result);

//        expression = "()v)";
//        removeInvalidParenthesis(expression);
    }
}
