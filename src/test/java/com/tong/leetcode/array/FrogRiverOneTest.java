package com.tong.leetcode.array;

import com.tong.leetcode.problem.array.FrogRiverOne;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FrogRiverOneTest {
    @Test
    void testSolution() {
        int[] input = {1, 3, 1, 4, 2, 3, 5, 4};
        Assertions.assertEquals(FrogRiverOne.solution2(5, input), 6);
    }
}
