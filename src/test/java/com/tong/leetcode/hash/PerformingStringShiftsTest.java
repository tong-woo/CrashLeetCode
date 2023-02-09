package com.tong.leetcode.hash;

import com.tong.leetcode.problem.hash.PerformingStringShifts;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class PerformingStringShiftsTest {

    @Mock
    PerformingStringShifts performingStringShifts = new PerformingStringShifts();

    @Test
    void testPerformingStringShifts(){

        int[][] shift = {{1,1}, {1,1}, {0,2}, {1,3}};
        String s = "abcdefg";
        String res = "efgabcd";

        Assertions.assertThat(performingStringShifts.stringShift(s, shift))
                .isEqualTo(res);
    }
}
