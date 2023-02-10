package com.tong.leetcode.slidingwindow;

import com.tong.leetcode.problem.slidingwindow.CountNumberOfNiceSubArrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountNumberOfNiceSubArraysTest {

    CountNumberOfNiceSubArrays countNumberOfNiceSubArrays = new CountNumberOfNiceSubArrays();

    @Test
    void testCountNumberOfNiceSubArrays(){
        int[] intArray = {1,1,2,1,1};
        int k = 3;

        Assertions.assertEquals(CountNumberOfNiceSubArrays.numberOfSubArrays(intArray, k), 2);
    }
}
