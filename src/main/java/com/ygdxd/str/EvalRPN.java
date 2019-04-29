package com.ygdxd.str;

import java.util.Stack;

/**
 * 根据逆波兰表示法，求表达式的值。
 *
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * @author Created by ygdxd_admin at 2019-03-30 4:32 PM
 */
public class EvalRPN {

    public int evalRPN(String[] tokens) {
        String operation = "+-*/";
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i< tokens.length; i++){
            if(operation.contains(tokens[i])){
                stack.push(Calc(tokens[i], stack.pop(), stack.pop()));
            }else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }

        return stack.pop();
    }

    public int Calc(String token,int y,int x) {
        if(token.equals("+")) {
            return x + y;
        }else if(token.equals("-")) {
            return x - y;
        }else if(token.equals("*")) {
            return x * y;
        }else if(token.equals("/")) {
            return x / y;
        }else {
            return 0;
        }
    }
}
