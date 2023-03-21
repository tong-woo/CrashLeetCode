package com.tong.leetcode.problem.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * mutation of FrogRiverOne
 * Codility https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/
 */
public class PermCheck {
    public int solution(int[] A) {
        // Implement your solution here
        HashSet<Integer> hashSet = new HashSet<>();
        int X = Arrays.stream(A).max().getAsInt();
        if (A.length != X) return 0;
        for (int num : A) {
            if (hashSet.add(num)) X--;
            if (X == 0) return 1;
        }
        return 0;
    }
}
