package com.tong.leetcode.hash;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.tong.leetcode.problem.hash.PerformingStringShifts;
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

        assertEquals(performingStringShifts.stringShift(s, shift), res);
    }
}
