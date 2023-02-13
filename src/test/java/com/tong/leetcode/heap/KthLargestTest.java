package com.tong.leetcode.heap;

import com.tong.leetcode.problem.heap.KthLargest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KthLargestTest {
    int k = 3;
    int[] input = new int[] {4,5,8,2};
    KthLargest kthLargest = new KthLargest(k, input);

    @Test
    void testKthLargestTest(){
        Assertions.assertEquals(kthLargest.add(3), 4);
        Assertions.assertEquals(kthLargest.add(5), 5);
        Assertions.assertEquals(kthLargest.add(10), 5);
        Assertions.assertEquals(kthLargest.add(9), 8);
        Assertions.assertEquals(kthLargest.add(4), 8);
    }
}
