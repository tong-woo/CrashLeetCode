package com.tong.leetcode.problem.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        Stack<Character> stack = new Stack<Character>();
        stack.push('d');
        // create dic "()[]{}"
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        // use stack
        if(s.length() > 0 && !map.containsKey(s.charAt(0))) return false;
        for(Character c : s.toCharArray()){
            if (map.containsKey(c)) stack.push(c);
            else if (map.get(stack.pop()) != c) return false;
        }
        return stack.size() == 1;
    }
}
