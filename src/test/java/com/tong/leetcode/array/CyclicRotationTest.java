package com.tong.leetcode.array;

import com.tong.leetcode.problem.array.CyclicRotation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class CyclicRotationTest {
    @Mock
    private final CyclicRotation cyclicRotation = new CyclicRotation();

    @Test
    void testCyclicRotationTest() {
        int[] inputArr = {1, 2, 3, 4, 5, 6, 7};
        int[] expectArr = {5, 6, 7, 1, 2, 3, 4};
        Assertions.assertThat(cyclicRotation.solution(inputArr, 3))
                .isEqualTo(expectArr);
    }
}
