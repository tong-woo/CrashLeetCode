package com.tong.leetcode.problem.stack;

import java.util.*;

/**
 * LeetCode 155
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 * @link https://leetcode.cn/problems/min-stack/
 */
class MinStack {

    private final Stack<Integer> minStack = new Stack<>();
    private final Stack<Integer> helperStack = new Stack<>();

    public MinStack() {}

    public void push(int val) {
        this.minStack.push(val);
        if(helperStack.isEmpty() || helperStack.peek() >= minStack.peek()){
            helperStack.push(val);
        }
    }

    public void pop() {
        if( minStack.pop().equals(helperStack.peek())){
            helperStack.pop();
        }
    }

    public int top() {
        return this.minStack.peek();
    }

    public int getMin() {
        return this.helperStack.peek();
    }
}
