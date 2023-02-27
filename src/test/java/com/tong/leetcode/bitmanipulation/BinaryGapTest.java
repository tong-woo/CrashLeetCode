package com.tong.leetcode.bitmanipulation;

import com.tong.leetcode.problem.bitmanipulation.BinaryGap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinaryGapTest {

    @Test
    void testBinaryGap() {
        // given
        int input = 1041;
        BinaryGap binaryGap = new BinaryGap();

        // then
        Assertions.assertEquals(binaryGap.binaryGap(input), 6);
    }
}
