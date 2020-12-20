package com.company.Linkedlist;

import java.util.Stack;

class Converter{
    // PostFix to exp Infix
    boolean isOperand(char charAt) {
        return (charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z');
    }
    int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    //Infix Operation
    String InToPost(String exp){
        String result = "";
        char c;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); ++i){
            c = exp.charAt(i);

            if (Character.isLetterOrDigit(c))
                result += c;

            else if (c == '(')
                stack.push(c);

            else if (c == ')'){
                while (!stack.isEmpty() && stack.peek() != '(')
                    result += stack.pop();

                stack.pop();
            }
            else {
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek()))
                    result += stack.pop();

                stack.push(c);
            }
            System.out.println("|  "+exp+" ||  "+result);
        }

        while (!stack.isEmpty()){
            if(stack.peek() == '(')
                return "Invalid Expression";
            result += stack.pop();
        }

        return result;
    }
    String inToPre(String exp) {
        Stack<Character> operators = new Stack<Character>();
        Stack<String> operands = new Stack<String>();
        String op1,op2;
        char op, c;

        for (int i = 0; i < exp.length(); i++) {
            c = exp.charAt(i);
            if (c == '(')
                operators.push(c);

            else if (c == ')') {
                while (!operators.empty() && operators.peek() != '(') {
                    op1 = operands.pop();
                    op2 = operands.pop();
                    op = operators.pop();

                    operands.push(op + op2 + op1);
                }
                operators.pop();
            }

            else if (isOperand(c))
                operands.push(c + "");
            else {
                while (!operators.empty() && Prec(c) <= Prec(operators.peek())) {
                    op1 = operands.pop();
                    op2 = operands.pop();
                    op = operators.pop();

                    operands.push(op + op2 + op1);
                }

                operators.push(c);
            }
            System.out.println("|  "+exp+" ||  "+operands.toString());
        }

        while (!operators.empty()){
            op1 = operands.pop();
            op2 = operands.pop();
            op = operators.pop();

            operands.push(op + op2 + op1);
        }
        return operands.peek();
    }

    //PostFix Operation
    String PostToIn(String exp){
        Stack<String> s = new Stack<String>();
        char c;
            for(int i = 0; i < exp.length(); i++){
                c = exp.charAt(i);
                if (isOperand(c)){
                    s.push(c + "");
                }
                else{
                    String b = s.pop();
                    String a = s.pop();
                    s.push("(" + a + c + b + ")");
                }

                System.out.println("|  "+exp+" ||  "+s.toString());
            }

            return s.peek();
    }
    String PostToPre(String exp) {
        Stack<String> s = new Stack<>();
        String op2,op1;
        char c;

        for (int i = 0; i < exp.length(); i++) {
            c = exp.charAt(i);
            if (!isOperand(c)) {
                op1 = s.pop();
                op2 = s.pop();

                s.push(c + op2 + op1);
            }
            else
                s.push(c+ "");

            System.out.println("|   "+exp+"    ||  "+s.toString());
        }

        return s.toString();
    }

    //Prefix Operation
    String PreToIn(String exp){
        Stack<String> s = new Stack<>();
        char c;
        String op1 ,op2;
        for(int i = exp.length()-1; i >= 0; i--){
            c = exp.charAt(i);

            if (!isOperand(c)) {
                op1 = s.pop();
                op2 = s.pop();

                s.push(")" + op2 + c + op1 + "(");
            }

            else s.push(c + "");
            System.out.println("|      "+exp+"       ||     "+(new StringBuilder(s.toString()).reverse())+"\b");
        }

        StringBuilder temp = (new StringBuilder(s.peek())).reverse();

    return temp.toString();
    }
    String PreToPost(String exp){
        Stack<String> s = new Stack<>();
        char c;
        String op1 ,op2;
        for(int i = exp.length()-1; i >= 0; i--){
            c = exp.charAt(i);

            if (!isOperand(c)) {
                op1 = s.pop();
                op2 = s.pop();

                s.push(  op1 +op2+ c );
            }

            else s.push(c + "");
            System.out.println("|      "+exp+"       ||  "+s.toString());
        }

        return s.peek();
    }

    int calculatePost(String exp){
        Stack<Integer> stack = new Stack<>();
        char c;
        int oper1, oper2;

        for (int i = 0; i < exp.length(); i++) {
            c = exp.charAt(i);

            if(Character.isDigit(c))
                stack.push(Integer.parseInt(String.valueOf(c)));
            else {
                oper1 = stack.pop();
                oper2 = stack.pop();

                stack.push((c == '+'?(oper2+oper1):(c == '-'?(oper2-oper1):(c == '*'?(oper2*oper1):(c == '/'?(oper2/oper1):0)))));
            }

        }

        return stack.pop();
    }
    int calculatePre(String exp){
        Stack<Integer> stack = new Stack<>();
        char c;
        int oper1, oper2;

        for (int i = exp.length()-1; i >= 0; i--) {
            c = exp.charAt(i);

            if(Character.isDigit(c))
                stack.push(Integer.parseInt(String.valueOf(c)));
            else {
                oper1 = stack.pop();
                oper2 = stack.pop();

                stack.push((c == '+'?(oper1+oper2):(c == '-'?(oper1-oper2):(c == '*'?(oper1*oper2):(c == '/'?(oper1/oper2):0)))));
            }

        }

        return stack.pop();
    }

}
public class Question2 {
    public static void main(String[] args) {
        Converter obj = new Converter();
        String exp;

////        part 1A in which the infix(parameterized) Convert in to postfix
//        exp = "a+b*(c^d-e)^(f+g*h)-i";
//        System.out.println("|          Infix         ||       Stack(Postfix)      |");
//        System.out.println("|------------------------||---------------------------|");
//        exp = obj.InToPost(exp);
//        System.out.println("|------------------------||---------------------------|");
//        System.out.println("\nFinal output: "+exp);
//
////        part 2A in which the infix(parameterized) Convert in to Prefix
//        exp = "a+b*(c^d-e)^(f+g*h)-i";
//        System.out.println("|------------------------||--------------------------|");
//        System.out.println("|          Infix         ||       Stack(Prefix)      |");
//        System.out.println("|------------------------||--------------------------|");
//        exp = obj.inToPre(exp);
//        System.out.println("|------------------------||--------------------------|");
//        System.out.println("\nFinal output: "+exp);
//
////        part 1B in which the postfix Convert in to infix(parameterized)
//        exp = "abcd^e-fgh*+^*+i-";
//        System.out.println("|------------------------||--------------------------|");
//        System.out.println("|        PostFix         ||        Stack(Infix)      |");
//        System.out.println("|------------------------||--------------------------|");
//        exp = obj.PostToIn(exp);
//        System.out.println("|------------------------||--------------------------|");
//        System.out.println("\nFinal output: "+exp);
//
////        part 2B in which the postfix Convert in to prefix
//        exp = "abcd^e-fgh*+^*+i-";
//        System.out.println("|------------------------||--------------------------|");
//        System.out.println("|        PostFix         ||        Stack(Prefix)     |");
//        System.out.println("|------------------------||--------------------------|");
//        exp = obj.PostToPre(exp);
//        System.out.println("|------------------------||--------------------------|");
//        System.out.println("\nFinal output: "+exp);
//
////        part 1C in which the prefix Convert in to Infix
//        exp = "-+a*b^-^cde+f*ghi";
//        System.out.println("|------------------------||--------------------------|");
//        System.out.println("|        Prefix          ||        Stack(Infix)      |");
//        System.out.println("|------------------------||--------------------------|");
//        exp = obj.PreToIn(exp);
//        System.out.println("|------------------------||--------------------------|");
//        System.out.println("\nFinal output: "+exp);
//
//
////        part 2C in which the prefix Convert in to postfix
//        exp = "-+a*b^-^cde+f*ghi";
//        System.out.println("|------------------------||--------------------------|");
//        System.out.println("|        PreFix          ||       Stack(Postfix)     |");
//        System.out.println("|------------------------||--------------------------|");
//        exp = obj.PreToPost(exp);
//        System.out.println("|------------------------||--------------------------|");
//        System.out.println("\nFinal output: "+exp);


//        exp="291*+8/";
//        System.out.println("postfix evaluation: "+obj.calculatePost(exp));

//        exp="+9*26";
//        System.out.println("postfix evaluation: "+obj.calculatePre(exp));

    }
}
