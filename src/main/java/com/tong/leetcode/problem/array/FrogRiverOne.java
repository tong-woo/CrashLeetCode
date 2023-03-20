package com.tong.leetcode.problem.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class FrogRiverOne {
    /**
     * Better solution using Set, no need to compare two array
     * Set to eliminate duplication
     * Time: O(N)
     * Space: O(M)
     */
    public static int solution2(int X, int[] A) {
        Set<Integer> values = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (values.add(A[i])) X--;
            if (X == 0) return i;
        }
        return -1;
    }

    /**
     * shit solution, all performance tests failed:(
     * Time: O(N) with way more bigger N
     * Space: O(M)
     */
    public int solution1(int X, int[] A) {
        final int[] path = IntStream.rangeClosed(1, X).toArray();
        // Implement your solution here
        if (A.length < X) return -1;
        for (int start = X - 1; start < A.length; start++) {
            int[] current = Arrays.copyOfRange(A, 0, start + 1);
            if (Arrays.equals(Arrays.stream(current).distinct().sorted().toArray(), path)) return start;
        }
        return -1;
    }
}
