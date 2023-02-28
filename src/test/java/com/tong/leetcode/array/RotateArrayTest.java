package com.tong.leetcode.array;

import com.tong.leetcode.problem.array.RotateArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class RotateArrayTest {
    @Mock
    RotateArray rotateArray = new RotateArray();

    @Test
    void testRotateArray() {
        //given
        int[] inputArr = {1, 2, 3, 4, 5, 6, 7};
        int[] expectArr = {5, 6, 7, 1, 2, 3, 4};
        //when
        rotateArray.rotate(inputArr, 3);
        //then
        Assertions.assertArrayEquals(inputArr, expectArr);
    }
}
