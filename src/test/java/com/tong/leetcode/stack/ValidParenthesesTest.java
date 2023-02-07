package com.tong.leetcode.stack;

import com.tong.leetcode.problem.stack.ValidParentheses;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class ValidParenthesesTest {

    @Mock
    ValidParentheses validParentheses = new ValidParentheses();

    @Test
    void testStringWithExpectedOutput(){
        String s = "()[]{}";
        Assertions.assertTrue(validParentheses.isValid(s));
    }
}
