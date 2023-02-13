package com.tong.leetcode.problem.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 1) return Integer.parseInt(tokens[0]);
        Stack<Integer> numStack = new Stack<>();
        int res = 0;
        for (String i : tokens) {
            if (isNumber(i)) {
                numStack.push(Integer.parseInt(i));
            } else {
                int num1 = numStack.pop();
                int num2 = numStack.pop();
                switch (i) {
                    case "+": res = num2 + num1;
                    case "-": res = num2 - num1;
                    case "*": res = num2 * num1;
                    case "/": res = num2 / num1;
                }
                numStack.push(res);
            }
        }
        return res;
    }

    public boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }
}
