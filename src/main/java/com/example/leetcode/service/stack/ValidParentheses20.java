package com.example.leetcode.service.stack;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidParentheses20 {
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

    @Test
    void testStringWithExpectedOutput(){
        String s = "()[]{}";
        Assertions.assertTrue(isValid(s));
    }

}
