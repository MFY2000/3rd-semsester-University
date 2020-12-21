package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

        Solution obj = new Solution();

        obj.removeInvalidParentheses("()(()()");
        System.out.println(obj.result);

//        obj.removeInvalidParentheses("(a)())()" );
//        System.out.println(obj.result);
//
//        obj.removeInvalidParentheses(")(");
//        System.out.println(obj.result);
    }

    ArrayList<String> result = new ArrayList<String>();
    int max=0;
    int i=0;
    public void removeInvalidParentheses(String s) {
        dfs(s, "", 0, 0);
    }

    public void dfs(String left, String right, int countLeft, int maxLeft){
        System.out.println(left+"," +right+","+ countLeft+","+ maxLeft);
        if(left.length()==0){
            if(countLeft==0 && right.length()!=0){
                max = maxLeft > max? maxLeft: max;
                if(maxLeft == max && !result.contains(right))
                    result.add(right);
            }
            return;
        }

        if(left.charAt(0) == '('){
            dfs(left.substring(1), right+"(", countLeft+1, maxLeft+1);//keep (
            dfs(left.substring(1), right, countLeft, maxLeft);//drop (
        }
        else if(left.charAt(0)==')'){
            if(countLeft>0)
                dfs(left.substring(1), right+")", countLeft-1, maxLeft);

            dfs(left.substring(1), right, countLeft, maxLeft);

        }else
            dfs(left.substring(1), right+String.valueOf(left.charAt(0)), countLeft, maxLeft);
    }
}