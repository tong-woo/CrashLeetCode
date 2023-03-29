package com.tong.leetcode.backtrack;

import com.tong.leetcode.problem.backtrack.GenerateParentheses;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class GenerateParenthesesTest {

    @Mock
    GenerateParentheses generateParentheses = new GenerateParentheses();

    @Test
    void testGenerateParentheses(){
        Assertions.assertThat(generateParentheses.generateParenthesis(3))
                .isEqualTo(List.of("((()))","(()())","(())()","()(())","()()()"));
    }
}
